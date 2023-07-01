package com.example.rickandmortyapp.ui.search.view

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.ui.search.view_model.FilterViewModel
import com.example.rickandmortyapp.ui.search.Filtros

class FilterActivity : AppCompatActivity() {

    private lateinit var viewModel: FilterViewModel

    lateinit var inputName: EditText
    lateinit var checkboxAlive: CheckBox
    lateinit var checkboxDead: CheckBox
    lateinit var checkboxUnknown: CheckBox
    lateinit var inputSpecies: EditText
    lateinit var inputType: EditText
    lateinit var checkboxFemale: CheckBox
    lateinit var checkboxMale: CheckBox
    lateinit var checkboxGenderless: CheckBox
    lateinit var checkboxGenderUnknown: CheckBox
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter2)

        viewModel = FilterViewModel(this)

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

        // Inicializar os valores das views com base nos valores das variáveis da classe Filtros
        inputName.setText(Filtros.name.value)
        inputSpecies.setText(Filtros.species.value)
        inputType.setText(Filtros.type.value)
        checkboxAlive.isChecked = Filtros.status.value == "alive"
        checkboxDead.isChecked = Filtros.status.value == "dead"
        checkboxUnknown.isChecked = Filtros.status.value == "unknown"
        checkboxFemale.isChecked = Filtros.gender.value == "female"
        checkboxMale.isChecked = Filtros.gender.value == "male"
        checkboxGenderless.isChecked = Filtros.gender.value == "genderless"
        checkboxGenderUnknown.isChecked = Filtros.gender.value == "unknown"

        setCheckboxOnClickListeners()

        button.setOnClickListener {
            viewModel.applyFilters()

            // Volta pra ultima Activity
            onBackPressed()
        }
    }

    private fun setCheckboxOnClickListeners(){

        setCheckboxStatusListeners()

        setCheckboxGenderListeners()
    }

    private fun setCheckboxStatusListeners(){
        checkboxAlive.setOnClickListener {
            if (checkboxAlive.isChecked) {
                checkboxDead.isChecked = false
                checkboxUnknown.isChecked = false
            }
        }

        checkboxDead.setOnClickListener {
            if (checkboxDead.isChecked) {
                checkboxAlive.isChecked = false
                checkboxUnknown.isChecked = false
            }
        }

        checkboxUnknown.setOnClickListener {
            if (checkboxUnknown.isChecked) {
                checkboxAlive.isChecked = false
                checkboxDead.isChecked = false
            }
        }
    }

    private fun setCheckboxGenderListeners(){
        checkboxFemale.setOnClickListener {
            if (checkboxFemale.isChecked) {
                checkboxMale.isChecked = false
                checkboxGenderless.isChecked = false
                checkboxGenderUnknown.isChecked = false
            }
        }

        checkboxMale.setOnClickListener {
            if (checkboxMale.isChecked) {
                checkboxFemale.isChecked = false
                checkboxGenderless.isChecked = false
                checkboxGenderUnknown.isChecked = false
            }
        }

        checkboxGenderless.setOnClickListener {
            if (checkboxGenderless.isChecked) {
                checkboxFemale.isChecked = false
                checkboxMale.isChecked = false
                checkboxGenderUnknown.isChecked = false
            }
        }

        checkboxGenderUnknown.setOnClickListener {
            if (checkboxGenderUnknown.isChecked) {
                checkboxFemale.isChecked = false
                checkboxMale.isChecked = false
                checkboxGenderless.isChecked = false
            }
        }
    }

}
