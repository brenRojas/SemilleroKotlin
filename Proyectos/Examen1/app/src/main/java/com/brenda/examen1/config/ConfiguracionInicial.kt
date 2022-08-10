package com.brenda.examen1.config

import android.app.Application

class ConfiguracionInicial: Application() {
    companion object{
        lateinit var preferenciasGlobal: Preferencias
    }

    override fun onCreate() {
        super.onCreate()
        preferenciasGlobal = Preferencias(applicationContext)
    }
}