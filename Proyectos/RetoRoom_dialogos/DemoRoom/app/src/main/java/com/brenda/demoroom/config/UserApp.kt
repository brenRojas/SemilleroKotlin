package com.brenda.demoroom.config

import android.app.Application
import androidx.room.Room

class UserApp:Application() {
    companion object{
        lateinit var basedatos:AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        basedatos = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "UsuariosDb"
        ).allowMainThreadQueries().build()
    }
}