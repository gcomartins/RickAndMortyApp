package com.example.rickandmortyapp.service

import com.example.rickandmortyapp.models.GetAllPersonagensResponse
import com.example.rickandmortyapp.models.Personagem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonagensService {

    @GET("character")
    fun getInitialCharacters(): retrofit2.Call<GetAllPersonagensResponse>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): retrofit2.Call<Personagem>

    @GET("/api/character")
    fun getMoreCharacters(@Query("page") page: Int): retrofit2.Call<GetAllPersonagensResponse>

}