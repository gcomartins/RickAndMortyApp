package com.example.rickandmortyapp.ui.personagens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.rickandmortyapp.R
import com.squareup.picasso.Picasso

class PersonagemExpandidoActivity : AppCompatActivity() {

    private var viewModel: PersonagensViewModel = PersonagensViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagem_expandido)

        val id = intent.getIntExtra("id", 0)
        viewModel.getCharacterById(id)

        val imagePersonagem = findViewById<ImageView>(R.id.imgPersonagem)
        val tvNomePersonagem = findViewById<TextView>(R.id.tvNomePersonagem)

        viewModel.character.observe(this){
            tvNomePersonagem.text = it.name

            Picasso.get()
                .load(it.image)
                .into(imagePersonagem)
        }
    }
}