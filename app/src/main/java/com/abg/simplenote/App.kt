package com.abg.simplenote

import android.app.Application
import com.abg.simplenote.data.AppDatabase

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
}