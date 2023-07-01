package com.example.rickandmortyapp.ui.personagens.model

data class GetAllPersonagensResponse(
    val info: Info,
    val results: List<Personagem>
)