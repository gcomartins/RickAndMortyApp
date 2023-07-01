package com.example.rickandmortyapp.ui.cenarios.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CenariosViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Fragment de Cenarios"
    }
    val text: LiveData<String> = _text
}