package com.example.quiz.screens

import android.R.attr.contentDescription
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier

) {
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
                .size(80.dp)
                .padding(vertical = 16.dp)
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = "Star Quiz",
            fontSize = 30.sp,
            color = Color(0xFFF3F4F6)
        )

        Spacer(Modifier.height(10.dp))


    }

}