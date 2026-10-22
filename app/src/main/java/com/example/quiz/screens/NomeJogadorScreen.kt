package com.example.quiz.screens


import android.R.attr.enabled
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NomeJogadorScreen(
    onIniciarQuiz: (String) -> Unit,
) {
    var nome by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF080B12))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "IDENTIFICAÇÃO JEDI",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFFE81F)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Antes de iniciar sua missão, identifique-se.",
            color = Color(0xFF9CA3AF),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))


        OutlinedTextField(
            value = nome,
            onValueChange = { novoTexto ->
                nome = novoTexto
            },
            label = {
                Text("Digite seu nome")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF4CC9F0),
                unfocusedBorderColor = Color(0xFF9CA3AF),
                focusedLabelColor = Color(0xFF4CC9F0),
                unfocusedLabelColor = Color(0xFF9CA3AF),
                focusedTextColor = Color(0xFFF3F4F6),
                unfocusedTextColor = Color(0xFFF3F4F6),
                cursorColor = Color(0xFFFFE81F)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFE81F),
                contentColor = Color(0xFF080B12)
            ),
            onClick = { onIniciarQuiz(nome.trim()) },
            enabled = nome.isNotBlank()
        ) {
            Text("INICIAR QUIZ")
        }
    }
}