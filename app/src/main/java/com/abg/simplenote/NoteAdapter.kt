package com.abg.simplenote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abg.simplenote.data.Note
import com.abg.simplenote.databinding.NoteBinding

class NoteAdapter(private val listOfNotes: List<Note>) : Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(private val noteBinding: NoteBinding): ViewHolder(noteBinding.root) {
        fun bind(title: String, date: String, time: String, body: String) {
            noteBinding.titleNote.text = title
            noteBinding.dateNote.text = "$date $time"
            noteBinding.bodyNote.text = body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoteViewHolder(NoteBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun getItemCount() = listOfNotes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = listOfNotes[position]
        holder.bind(note.title, note.date, note.time, note.body)
    }
}