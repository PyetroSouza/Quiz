package com.example.quiz.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.R
import com.example.quiz.perguntas.Pergunta
import com.example.quiz.components.ContadorPerguntas

@Composable
fun CardPergunta(
    pergunta: Pergunta,
    respostaCorreta: Boolean?,
    aoResponder: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .width(350.dp)
            .background(Color(0xFF111827))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            modifier = Modifier.padding(
                vertical = 10.dp,
                horizontal = 5.dp
            ),
            text = pergunta.enunciado,
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            color = Color(0xFFF3F4F6),
            textAlign = TextAlign.Center,
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(5.dp))

        pergunta.opcoes.forEach { opcaoText ->
            BotaoAlternativa(
                texto = opcaoText,
                habilitado = respostaCorreta == null,
                aoClicar = {
                    aoResponder(opcaoText)
                }
            )
        }

        FeedbackResposta(
            respostaCorreta = respostaCorreta
        )
    }
}
