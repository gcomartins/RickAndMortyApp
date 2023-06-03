package com.example.rickandmortyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.imageView.setImageResource(R.drawable.ricknmorty)
        binding.tvTitulo.text = context?.getText(R.string.titulo_home_page)
        binding.tvApresentacao.text = context?.getText(R.string.apresentacao_home_page)
        binding.tvDescricao.text = context?.getText(R.string.description_home_page)

        return root
    }
}