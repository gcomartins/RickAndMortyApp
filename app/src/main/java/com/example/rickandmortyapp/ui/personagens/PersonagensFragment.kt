package com.example.rickandmortyapp.ui.personagens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.rickandmortyapp.databinding.FragmentGalleryBinding
import com.example.rickandmortyapp.databinding.FragmentPersonagensBinding

class PersonagensFragment : Fragment() {

    private var _binding: FragmentPersonagensBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this).get(PersonagensViewModel::class.java)

        _binding = FragmentPersonagensBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        textView.setOnClickListener{
            viewModel.changeText("Ai ai ui ui")
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}