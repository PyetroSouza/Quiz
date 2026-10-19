package com.example.quiz.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun FeedbackResposta(respostaCorreta: Boolean?) {
    if (respostaCorreta != null) {
        Text(
            text = if (respostaCorreta) "CORRETO!" else "ERRADO!",
            color = if (respostaCorreta) Color(0xFF4ADE80)
            else Color(0xFFF87171),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
