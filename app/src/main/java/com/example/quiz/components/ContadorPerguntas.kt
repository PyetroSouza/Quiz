package com.example.quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R

@Composable
fun ContadorPerguntas(
    indiceAtual: Int,
    totalPerguntas: Int
) {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(300.dp)
            .background(Color(0xFF111827)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Pergunta de ${indiceAtual?.plus(1) ?: 1} de ${totalPerguntas}",
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight.W600,
            fontSize = 20.sp,
            color = Color(0xFFF3F4F6)
        )
    }
}