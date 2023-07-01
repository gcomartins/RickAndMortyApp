package com.example.rickandmortyapp.ui.search

import androidx.lifecycle.MutableLiveData

class Filtros(

){
     companion object {
         var name: MutableLiveData<String?> = MutableLiveData(null)
         var status: MutableLiveData<String?> = MutableLiveData(null)
         var species: MutableLiveData<String?> = MutableLiveData(null)
         var type: MutableLiveData<String?> = MutableLiveData(null)
         var gender: MutableLiveData<String?> = MutableLiveData(null)
         var hasFilters: MutableLiveData<Boolean> = MutableLiveData(false)
     }
 }
