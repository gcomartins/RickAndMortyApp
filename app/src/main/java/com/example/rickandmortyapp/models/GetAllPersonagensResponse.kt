package com.example.rickandmortyapp.models

data class GetAllPersonagensResponse(
    val info: Info,
    val results: List<Personagem>
)