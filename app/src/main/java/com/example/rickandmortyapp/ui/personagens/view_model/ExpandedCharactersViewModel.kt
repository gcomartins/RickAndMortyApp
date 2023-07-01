package com.example.rickandmortyapp.ui.personagens.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapp.rest.Rest
import com.example.rickandmortyapp.service.PersonagensService
import com.example.rickandmortyapp.ui.personagens.model.Personagem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExpandedCharactersViewModel {
    private val retrofit = Rest.getInstance()
    val service = retrofit.create(PersonagensService::class.java)

    private val _character = MutableLiveData<Personagem>()
    var character: LiveData<Personagem> = _character

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
}