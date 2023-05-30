package com.example.rickandmortyapp.ui.personagens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.models.Personagem

class PersonagensViewModel : ViewModel() {
    var characters = MutableLiveData<List<Personagem>>()

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento de Personagens"
    }
    val text: LiveData<String> = _text

    fun changeText(text: String) {
        _text.value = text
    }
}