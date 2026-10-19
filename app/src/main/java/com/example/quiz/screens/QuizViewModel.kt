package com.example.quiz.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiz.perguntas.Pergunta

class QuizViewModel : ViewModel() {
    private val _indicePergunta = MutableLiveData<Int>(0)
    val indicePergunta: LiveData<Int> = _indicePergunta

    private val _respostaCorreta = MutableLiveData<Boolean?>(null)
    val respostaCorreta: LiveData<Boolean?> = _respostaCorreta

    private val _quizFinalizado = MutableLiveData(false)
    val quizFinalizado: LiveData<Boolean> = _quizFinalizado

    private val _pontuacao = MutableLiveData(0)
    val pontuacao: LiveData<Int> = _pontuacao

    private val perguntas = listOf(
        Pergunta(
            enunciado = "Quem treinou Luke em Dagobah?",
            opcoes = listOf(
                "Obi-Wan Kenobi",
                "Yoda",
                "Qui-Gon Jinn",
                "Mestre Mace Windu"
            ),
            respostaCorreta = "Yoda"
        ),

        Pergunta(
            enunciado = "Qual é o sobrenome de Leia?",
            opcoes = listOf(
                "Skywalker",
                "Kenobi",
                "Organa",
                "Palpatine"
            ),
            respostaCorreta = "Organa"
        ),

        Pergunta(
            enunciado = "Qual é o planeta natal de Anakin?",
            opcoes = listOf(
                "Naboo",
                "Tatooine",
                "Dagobah",
                "Kashyyyk"
            ),
            respostaCorreta = "Tatooine"
        )
    )

    val totalPerguntas: Int
        get() = perguntas.size


    private val _perguntaAtual = MutableLiveData(perguntas[0])
    val perguntaAtual: LiveData<Pergunta> = _perguntaAtual


    fun verificarResposta(opcaoEscolhida: String) {
        if (_respostaCorreta.value != null) return

        val pergunta = _perguntaAtual.value ?: return
        _respostaCorreta.value =
            opcaoEscolhida == pergunta.respostaCorreta

        val acertou = opcaoEscolhida == pergunta.respostaCorreta

        _respostaCorreta.value = acertou

        if (acertou) {
            _pontuacao.value = (_pontuacao.value ?: 0) + 1
        }
    }

    fun proximaPergunta() {
        val proximoIndice = (_indicePergunta.value ?: 0) + 1

        if (proximoIndice < perguntas.size) {
            _indicePergunta.value = proximoIndice
            _perguntaAtual.value = perguntas[proximoIndice]
            _respostaCorreta.value = null
        } else {
            _quizFinalizado.value = true
        }
    }

    fun reiniciarQuiz() {
        _indicePergunta.value = 0
        _perguntaAtual.value = perguntas[0]
        _respostaCorreta.value = null
        _pontuacao.value = 0
        _quizFinalizado.value = false
    }
}