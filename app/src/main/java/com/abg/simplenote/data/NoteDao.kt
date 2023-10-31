package com.abg.simplenote.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAll() : List<Note>

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id: Int) : List<Note>

    @Query("SELECT * FROM notes WHERE title LIKE :search ORDER BY id DESC")
    fun getByTitle(search: String?): List<Note>

    @Query("SELECT * FROM notes WHERE label = :id ORDER BY id DESC")
    fun getByLabel(id: String) : List<Note>
}