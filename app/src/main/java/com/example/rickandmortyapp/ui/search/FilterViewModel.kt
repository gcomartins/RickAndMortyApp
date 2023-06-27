package com.example.rickandmortyapp.ui.search

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapp.models.Filtros

class FilterViewModel(
    val activity: FilterActivity,
): ViewModel() {
    fun applyFilters() {
        // Atualizar os valores das variáveis da classe Filtros com base nos inputs do usuário
        Filtros.name.value = activity.inputName.text.toString()
        Filtros.status.value = getStatusFilter()
        Filtros.species.value = activity.inputSpecies.text.toString()
        Filtros.type.value = activity.inputType.text.toString()
        Filtros.gender.value = getGenderFilter()
        Filtros.hasFilters.value = checkHasFilters()
    }

    fun getStatusFilter(): String? {
        return when {
            activity.checkboxAlive.isChecked -> "alive"
            activity.checkboxDead.isChecked -> "dead"
            activity.checkboxUnknown.isChecked -> "unknown"
            else -> null
        }
    }

    fun getGenderFilter(): String? {
        return when {
            activity.checkboxFemale.isChecked -> "female"
            activity.checkboxMale.isChecked -> "male"
            activity.checkboxGenderless.isChecked -> "genderless"
            activity.checkboxGenderUnknown.isChecked -> "unknown"
            else -> null
        }
    }

    private fun checkHasFilters(): Boolean {
        val response = listOf(
            Filtros.name.value,
            Filtros.status.value,
            Filtros.species.value,
            Filtros.type.value,
            Filtros.gender.value
        ).any { !it.isNullOrBlank() }

        return response
    }

}