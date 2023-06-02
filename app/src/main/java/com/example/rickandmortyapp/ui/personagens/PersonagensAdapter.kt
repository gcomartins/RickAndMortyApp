package com.example.rickandmortyapp.ui.personagens

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.models.Personagem
import com.squareup.picasso.Picasso

class PersonagensAdapter(
    val context: Context,
    val personagens: List<Personagem>
    ):
    RecyclerView.Adapter<PersonagensAdapter.PersonagensViewHolder>() {

    inner class PersonagensViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(personagem: Personagem){
            val card = itemView.findViewById<CardView>(R.id.cardPersonagem)
            val tvNomePersonagem = itemView.findViewById<TextView>(R.id.txtNomePersonagem)
            val tvStatus = itemView.findViewById<TextView>(R.id.txtStatus)
            val tvEspecie = itemView.findViewById<TextView>(R.id.txtEspecie)
            val tvLocation = itemView.findViewById<TextView>(R.id.txtLocation)
            val tvFirstLocation = itemView.findViewById<TextView>(R.id.txtFirstLocation)

            val ImagePersonagem = itemView.findViewById<ImageView>(R.id.imgPersonagem)

            tvNomePersonagem.text = personagem.name
            tvStatus.text = personagem.status
            tvEspecie.text = personagem.species
            tvLocation.text = personagem.location.name
            tvFirstLocation.text = personagem.origin.name

            Picasso.get()
                .load(personagem.image)
                .into(ImagePersonagem)

            card.setOnClickListener{
                val intent = Intent(context, PersonagemExpandidoActivity::class.java)

                intent.putExtra("image", personagem.image)
                intent.putExtra("nome", personagem.name)
                intent.putExtra("id", personagem.id)

                context.startActivity(intent)
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagensViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personagem, parent, false)
        return PersonagensViewHolder(view)
    }

    override fun getItemCount(): Int = personagens.size

    override fun onBindViewHolder(holder: PersonagensViewHolder, position: Int) {
        val personagem = personagens[position]
        holder.bind(personagem)
    }
}