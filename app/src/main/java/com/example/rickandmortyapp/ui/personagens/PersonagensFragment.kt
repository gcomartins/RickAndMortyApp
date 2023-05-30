package com.example.rickandmortyapp.ui.personagens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.rickandmortyapp.databinding.FragmentGalleryBinding
import com.example.rickandmortyapp.databinding.FragmentPersonagensBinding
import com.example.rickandmortyapp.models.GetAllPersonagensResponse
import com.example.rickandmortyapp.models.Personagem
import com.example.rickandmortyapp.rest.Rest
import com.example.rickandmortyapp.service.PersonagensService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonagensFragment : Fragment() {

    private var _binding: FragmentPersonagensBinding? = null

    private val binding get() = _binding!!

    private val retrofit = Rest.getInstance()

    private var viewModel: PersonagensViewModel = PersonagensViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonagensBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllCharacters()
    }

    private fun getAllCharacters() {
        val service = retrofit.create(PersonagensService::class.java)
        val call = service.getAllUsers()
        call.enqueue(object : Callback<GetAllPersonagensResponse> {
            override fun onResponse(
                call: Call<GetAllPersonagensResponse>,
                response: Response<GetAllPersonagensResponse>
            ) {
                if (response.isSuccessful) {
                    val body = response.body()
                    viewModel.characters.value = body?.results
                }
            }

            override fun onFailure(call: Call<GetAllPersonagensResponse>, t: Throwable) {
                Log.e("PersonagemService   ", "Erro ao buscar o personagem:" + t.message)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}