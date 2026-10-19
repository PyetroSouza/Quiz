package com.example.quiz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.R
import com.example.quiz.components.FeedbackResposta
import com.example.quiz.components.TelaFinalQuiz
import kotlinx.coroutines.delay

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier, navController: NavController,
    viewModel: QuizViewModel = viewModel()
) {
    val perguntaAtual by viewModel.perguntaAtual.observeAsState()
    val indicePergunta by viewModel.indicePergunta.observeAsState()
    val respostaCorreta by viewModel.respostaCorreta.observeAsState()
    val quizFinalizado by viewModel.quizFinalizado.observeAsState(false)
    val pontuacao by viewModel.pontuacao.observeAsState(0)

    if (perguntaAtual == null) return

    if (quizFinalizado) {
        TelaFinalQuiz(
            pontuacao = pontuacao,
            totalPerguntas = viewModel.totalPerguntas,
            onJogarNovamente = {
                viewModel.reiniciarQuiz()
            }
        )
        return
    }

    LaunchedEffect(respostaCorreta) {
        if (respostaCorreta != null) {
            delay(1500)
            viewModel.proximaPergunta()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF080B12)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.starlogo),
            contentDescription = "Logo APP",
            modifier = Modifier
                .size(120.dp)
                .padding(vertical = 16.dp)
        )

        Box(
            modifier = Modifier
                .height(50.dp)
                .width(300.dp)
                .background(Color(0xFF111827)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Pergunta de ${indicePergunta?.plus(1) ?: 1} de 3",
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                color = Color(0xFFF3F4F6)
            )
        }

        Spacer(modifier.height(30.dp))
        Column(
            modifier = Modifier
                .width(350.dp)
                .background(Color(0xFF111827))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                text = perguntaAtual!!.enunciado,
                fontWeight = FontWeight.W600,
                fontSize = 20.sp,
                color = Color(0xFFF3F4F6),
                textAlign = TextAlign.Center,
                letterSpacing = 1.sp

            )

            Spacer(modifier.height(5.dp))

            perguntaAtual!!.opcoes.forEach { opcaoText ->
                Button(
                    onClick = {
                        viewModel.verificarResposta(opcaoText)
                    },
                    enabled = respostaCorreta == null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1E2937)
                    ),
                ) {
                    Text(
                        text = opcaoText,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp),
                        fontFamily = FontFamily(Font(R.font.roboto))
                    )
                }
            }
            FeedbackResposta(respostaCorreta = respostaCorreta)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen(
        navController = rememberNavController()
    )
}