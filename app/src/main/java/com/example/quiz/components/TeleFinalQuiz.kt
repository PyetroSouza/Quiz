package com.example.quiz.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TelaFinalQuiz(
    nomeJogador: String,
    pontuacao: Int,
    totalPerguntas: Int,
    onJogarNovamente: () -> Unit,

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF080B12))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "BOM TRABALHO, $nomeJogador!",
            color = Color(0xFFFFE81F),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Que a Força esteja com você!",
            color = Color(0xFFF3F4F6),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Sua pontuação",
            color = Color(0xFF4CC9F0),
            fontSize = 20.sp
        )

        Text(
            text = "$pontuacao / $totalPerguntas",
            color = Color(0xFFF3F4F6),
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onJogarNovamente,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFE81F),
                contentColor = Color(0xFF080B12)
            )
        ) {
            Text(
                text = "JOGAR NOVAMENTE",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

