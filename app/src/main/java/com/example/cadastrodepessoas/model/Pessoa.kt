package com.example.cadastrodepessoas.model

data class Pessoa(
    val nome: String,
    val endereco: String,
    val estado: String,
    val cidade: String,
    val telefone: String,
    val email: String,
    var emDia: Boolean
)