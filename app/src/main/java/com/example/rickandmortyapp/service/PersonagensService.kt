package com.example.rickandmortyapp.service

import com.example.rickandmortyapp.ui.personagens.model.GetAllPersonagensResponse
import com.example.rickandmortyapp.ui.personagens.model.Personagem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonagensService {

    @GET("character")
    fun getCharacters(
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("species") species: String? = null,
        @Query("type") type: String? = null,
        @Query("gender") gender: String? = null,
        @Query("page") page: Int = 1,
    ): retrofit2.Call<GetAllPersonagensResponse>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): retrofit2.Call<Personagem>

}