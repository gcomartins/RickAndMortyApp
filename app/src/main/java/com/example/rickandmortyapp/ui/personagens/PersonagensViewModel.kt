package com.example.rickandmortyapp.ui.personagens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.models.Filtros
import com.example.rickandmortyapp.models.GetAllPersonagensResponse
import com.example.rickandmortyapp.models.Personagem
import com.example.rickandmortyapp.rest.Rest
import com.example.rickandmortyapp.service.PersonagensService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonagensViewModel: ViewModel() {
    private val retrofit = Rest.getInstance()
    val service = retrofit.create(PersonagensService::class.java)

    private val _character = MutableLiveData<Personagem>()
    private val _characters = MutableLiveData<List<Personagem>>()

    var character: LiveData<Personagem> = _character
    val characters: LiveData<List<Personagem>> = _characters

    var currentPage: Int = 1

    fun getInitialCharacters() {
        val call = service.getCharacters(
            name = Filtros.name,
            status = Filtros.status,
            species = Filtros.species,
            type = Filtros.type,
            gender = Filtros.gender,
        )
        call.enqueue(object : Callback<GetAllPersonagensResponse> {
            override fun onResponse(
                call: Call<GetAllPersonagensResponse>,
                response: Response<GetAllPersonagensResponse>
            ) {
                if (response.isSuccessful) {
                    _characters.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<GetAllPersonagensResponse>, t: Throwable) {
                Log.e("PersonagemService   ", "Erro ao buscar o personagem:" + t.message)
            }
        })
    }

    fun getCharacterById(id: Int){
        val call = service.getCharacterById(id)
        call.enqueue(object : Callback<Personagem> {
            override fun onResponse(
                call: Call<Personagem>,
                response: Response<Personagem>
            ) {
                if (response.isSuccessful) {
                    _character.value = response.body()
                }
            }

            override fun onFailure(call: Call<Personagem>, t: Throwable) {
                Log.e("PersonagemService   ", "Erro ao buscar o personagem:" + t.message)
            }
        })
    }

    fun getMoreCharacters(){
        currentPage++
        val call = service.getCharacters(
            page=currentPage,
            name = Filtros.name,
            status = Filtros.status,
            species = Filtros.species,
            type = Filtros.type,
            gender = Filtros.gender,
        )
        call.enqueue(object : Callback<GetAllPersonagensResponse> {
            override fun onResponse(
                call: Call<GetAllPersonagensResponse>,
                response: Response<GetAllPersonagensResponse>
            ) {
                if (response.isSuccessful) {
                    _characters.value = response.body()?.results

                    print(characters.value)
                }
            }

            override fun onFailure(call: Call<GetAllPersonagensResponse>, t: Throwable) {
                Log.e("PersonagemService   ", "Erro ao buscar o personagem:" + t.message)
            }
        })
    }
}