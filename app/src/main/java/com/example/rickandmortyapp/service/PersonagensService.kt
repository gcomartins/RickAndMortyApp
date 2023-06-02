package com.example.rickandmortyapp.service

import com.example.rickandmortyapp.models.GetAllPersonagensResponse
import com.example.rickandmortyapp.models.Personagem
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonagensService {

    @GET("character")
    fun getAllUsers(): retrofit2.Call<GetAllPersonagensResponse>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): retrofit2.Call<Personagem>

}