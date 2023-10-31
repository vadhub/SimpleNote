package com.abg.simplenote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.abg.simplenote.databinding.FragmentListNotestBinding

class ListNotes : Fragment() {

    private lateinit var binding: FragmentListNotestBinding
    private val viewModel: NoteViewModel by activityViewModels { NoteViewModelFactory(((requireActivity() as MainActivity).application as App).database.getNoteDao()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListNotestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.recyclerView

        viewModel.getAll()

        viewModel.noteLiveData.observe(viewLifecycleOwner) {
            val adapter = NoteAdapter(it)
            recyclerView.adapter = adapter
        }

    }

}