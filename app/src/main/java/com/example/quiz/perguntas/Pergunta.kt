package com.example.quiz.perguntas

data class Pergunta(
    val enunciado: String,
    val opcoes: List<String>,
    val respostaCorreta: String
)