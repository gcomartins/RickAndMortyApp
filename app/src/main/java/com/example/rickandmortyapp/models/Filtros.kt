package com.example.rickandmortyapp.models

import androidx.lifecycle.MutableLiveData

class Filtros(

){
     companion object {
         var name: MutableLiveData<String?> = MutableLiveData(null)
         var status: MutableLiveData<String?> = MutableLiveData(null)
         var species: MutableLiveData<String?> = MutableLiveData(null)
         var type: MutableLiveData<String?> = MutableLiveData(null)
         var gender: MutableLiveData<String?> = MutableLiveData(null)
     }
 }
