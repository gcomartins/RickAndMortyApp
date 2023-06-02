package com.example.rickandmortyapp.ui.personagens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.components.InfiniteScrollListener
import com.example.rickandmortyapp.databinding.FragmentPersonagensBinding

class PersonagensFragment : Fragment() {

    private var _binding: FragmentPersonagensBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonagensViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var infiniteScrollListener: InfiniteScrollListener
    private lateinit var adapter: PersonagensAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonagensBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.rvPersonagens
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        adapter = PersonagensAdapter(requireContext(), emptyList())
        recyclerView.adapter = adapter

        infiniteScrollListener = InfiniteScrollListener(layoutManager) {
            viewModel.getMoreCharacters()
        }
        recyclerView.addOnScrollListener(infiniteScrollListener)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PersonagensViewModel::class.java)
        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            adapter.setData(characters)
            infiniteScrollListener.setLoading(false)
        }

        viewModel.getInitialCharacters()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
