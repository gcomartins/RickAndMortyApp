package com.example.rickandmortyapp.ui.personagens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.components.InfiniteScrollListener
import com.example.rickandmortyapp.databinding.FragmentPersonagensBinding
import com.example.rickandmortyapp.models.Filtros

class CharactersFragment : Fragment() {

    private var _binding: FragmentPersonagensBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharactersViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var infiniteScrollListener: InfiniteScrollListener
    private lateinit var adapter: CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonagensBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)

        recyclerView = binding.rvPersonagens
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        adapter = CharactersAdapter(requireContext(), emptyList())
        recyclerView.adapter = adapter

        infiniteScrollListener = InfiniteScrollListener(layoutManager) {
            viewModel.getMoreCharacters()
        }
        recyclerView.addOnScrollListener(infiniteScrollListener)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            adapter.setData(characters)
            infiniteScrollListener.setLoading(false)
        }

        viewModel.getInitialCharacters()

        initFiltrosObservers()
    }

    private fun initFiltrosObservers() {
        val filtros = listOf(
            Filtros.name,
            Filtros.gender,
            Filtros.type,
            Filtros.status,
            Filtros.species
        )

        filtros.forEach { filtro ->
            filtro.observe(viewLifecycleOwner) {
                reloadPage(it)
                Filtros.hasFilters.value = true
            }
        }

        Filtros.hasFilters.observe(viewLifecycleOwner){
            if(!it){
                print(it)
                reloadPage("reload")
            }
        }
    }


    private fun reloadPage(data: String?) {
        if (!data.isNullOrBlank()) {
            adapter.clearCharactersList()
            viewModel.getInitialCharacters()
        }
    }

}
