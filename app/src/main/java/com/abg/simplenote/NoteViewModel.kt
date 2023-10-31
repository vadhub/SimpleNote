package com.abg.simplenote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.abg.simplenote.data.Note
import com.abg.simplenote.data.NoteDao
import kotlinx.coroutines.launch

class NoteViewModel(private val noteDao: NoteDao) : ViewModel() {

    private val _noteLiveData = MutableLiveData<List<Note>>()
    val noteLiveData
        get() = _noteLiveData

    fun insert(note: Note) {
        noteDao.insert(note)
    }

    fun delete(note: Note) {
        viewModelScope.launch { noteDao.delete(note) }
    }

    fun getAll() {
        viewModelScope.launch {
            noteDao.getAll()
        }
    }
}

class NoteViewModelFactory(private val noteDao: NoteDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(noteDao) as T
    }
}