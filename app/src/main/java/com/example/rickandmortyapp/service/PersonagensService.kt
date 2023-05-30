package com.example.rickandmortyapp.service

import com.example.rickandmortyapp.models.GetAllPersonagensResponse
import com.example.rickandmortyapp.models.Personagem
import retrofit2.http.GET

interface PersonagensService {

    @GET("character")
    fun getAllUsers(): retrofit2.Call<GetAllPersonagensResponse>

}