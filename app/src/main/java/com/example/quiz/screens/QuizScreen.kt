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
import com.example.quiz.components.BotaoAlternativa
import com.example.quiz.components.CardPergunta
import com.example.quiz.components.ContadorPerguntas
import com.example.quiz.components.FeedbackResposta
import com.example.quiz.components.TelaFinalQuiz
import kotlinx.coroutines.delay

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    nomeJogador: String,
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
            nomeJogador = nomeJogador,
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
        ContadorPerguntas(
            indiceAtual = indicePergunta ?: 0,
            totalPerguntas = viewModel.totalPerguntas
        )
        Spacer(modifier.height(20.dp))

        CardPergunta(
            pergunta = perguntaAtual!!,
            respostaCorreta = respostaCorreta,
            aoResponder = { opcao ->
                viewModel.verificarResposta(opcao)
            }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen(
        navController = rememberNavController(),
        nomeJogador = "bungas"
    )
}