package com.example.quiz.screens

import android.R.attr.contentDescription
import android.R.attr.fontFamily
import android.R.attr.fontWeight
import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onComecar: ()-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF080B12)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {
        Image(
            painter = painterResource(R.drawable.starlogo),
            contentDescription = "Logo APP",
            modifier = Modifier
                .size(120.dp)
                .padding(vertical = 16.dp)
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "QUIZ GALÁCTICO",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.orbitron)),
            color = Color(0xFFF3F4F6)
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = onComecar,
            colors = ButtonDefaults.buttonColors(Color(0xFFFFE81F)),
            modifier = Modifier.size(width = 300.dp, height = 50.dp)
        ) {
            Text(
                text = "COMEÇAR",
                fontSize = 20.sp,
                color = Color.Black
            )
        }


    }

}