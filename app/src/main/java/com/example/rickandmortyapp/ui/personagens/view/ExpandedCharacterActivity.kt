package com.example.rickandmortyapp.ui.personagens.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rickandmortyapp.databinding.ActivityPersonagemExpandidoBinding
import com.example.rickandmortyapp.ui.personagens.view_model.CharactersViewModel
import com.squareup.picasso.Picasso

class ExpandedCharacterActivity : AppCompatActivity() {

    private var _binding: ActivityPersonagemExpandidoBinding? = null

    private val binding get() = _binding!!

    private var viewModel: CharactersViewModel = CharactersViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPersonagemExpandidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", 0)
        viewModel.getCharacterById(id)

        val imagePersonagem = binding.imgPersonagem
        val tvIdPersonagem = binding.tvIdPersonagem
        val tvNomePersonagem = binding.tvNomePersonagem
        val tvStatusPersonagem = binding.tvStatusPersonagem
        val tvGenderPersonagem = binding.tvGenderPersonagem
        val tvSpeciePersonagem = binding.tvSpeciePersonagem
        val tvCreatedAtPersonagem = binding.tvCreatedAtPersonagem
        val tvNomeOrigemPersonagem = binding.tvOriginPersonagem
        val tvLocalizacaoPersonagem = binding.tvLocationPersonagem

        viewModel.character.observe(this){personagem ->
            Picasso.get()
                .load(personagem.image)
                .into(imagePersonagem)

            tvIdPersonagem.text = personagem.id.toString()
            tvNomePersonagem.text = personagem.name
            tvStatusPersonagem.text = personagem.status
            tvGenderPersonagem.text = personagem.gender
            tvSpeciePersonagem.text = personagem.species
            tvCreatedAtPersonagem.text = personagem.created
            tvNomeOrigemPersonagem.text = personagem.origin.name
            tvLocalizacaoPersonagem.text = personagem.location.name
        }
    }
}