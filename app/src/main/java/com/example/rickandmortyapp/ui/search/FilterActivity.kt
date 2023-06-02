package com.example.rickandmortyapp.ui.search

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.models.Filtros

class FilterActivity : AppCompatActivity() {
    private lateinit var inputName: EditText
    private lateinit var checkboxAlive: CheckBox
    private lateinit var checkboxDead: CheckBox
    private lateinit var checkboxUnknown: CheckBox
    private lateinit var inputSpecies: EditText
    private lateinit var inputType: EditText
    private lateinit var checkboxFemale: CheckBox
    private lateinit var checkboxMale: CheckBox
    private lateinit var checkboxGenderless: CheckBox
    private lateinit var checkboxGenderUnknown: CheckBox
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter2)

        // Inicializar as views do layout
        inputName = findViewById(R.id.input_name)
        checkboxAlive = findViewById(R.id.checkbox_alive)
        checkboxDead = findViewById(R.id.checkbox_dead)
        checkboxUnknown = findViewById(R.id.checkbox_unknown)
        inputSpecies = findViewById(R.id.input_species)
        inputType = findViewById(R.id.input_type)
        checkboxFemale = findViewById(R.id.checkbox_female)
        checkboxMale = findViewById(R.id.checkbox_male)
        checkboxGenderless = findViewById(R.id.checkbox_genderless)
        checkboxGenderUnknown = findViewById(R.id.checkbox_gender_unknown)
        button = findViewById(R.id.button_filter)

        button.setOnClickListener {
            applyFilters(it)
        }
    }

    fun applyFilters(view: View) {
        // Atualizar os valores das variáveis da classe Filtros com base nos inputs do usuário
        Filtros.name = inputName.text.toString()
        Filtros.status = getStatusFilter()
        Filtros.species = inputSpecies.text.toString()
        Filtros.type = inputType.text.toString()
        Filtros.gender = getGenderFilter()

        // Realizar a ação desejada com os filtros aplicados, por exemplo, retornar para a atividade anterior
        onBackPressed()
    }

    private fun getStatusFilter(): String? {
        return when {
            checkboxAlive.isChecked -> "alive"
            checkboxDead.isChecked -> "dead"
            checkboxUnknown.isChecked -> "unknown"
            else -> null
        }
    }

    private fun getGenderFilter(): String? {
        return when {
            checkboxFemale.isChecked -> "female"
            checkboxMale.isChecked -> "male"
            checkboxGenderless.isChecked -> "genderless"
            checkboxGenderUnknown.isChecked -> "unknown"
            else -> null
        }
    }

}
