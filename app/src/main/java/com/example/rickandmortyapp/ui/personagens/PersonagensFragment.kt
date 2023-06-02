package com.example.rickandmortyapp.ui.personagens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.databinding.FragmentPersonagensBinding

class PersonagensFragment : Fragment() {

    private var _binding: FragmentPersonagensBinding? = null

    private val binding get() = _binding!!

    private var viewModel: PersonagensViewModel = PersonagensViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonagensBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView: RecyclerView = binding.rvPersonagens

        viewModel.characters.observe(requireActivity()){
            recyclerView.adapter = PersonagensAdapter(requireContext(), it)
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllCharacters()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}