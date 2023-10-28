package com.abg.simplenote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    // Create database here
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "note_db"
                    )
                        .allowMainThreadQueries() //allows Room to executing task in main thread
                        .fallbackToDestructiveMigration() //allows Room to recreate database if no migrations found
                        .build()

                    INSTANCE = instance
                    instance
                }
        }
    }

    abstract fun getNoteDao() : NoteDao
}