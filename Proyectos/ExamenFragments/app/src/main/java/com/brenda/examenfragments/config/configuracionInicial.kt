package com.brenda.examenfragments.config

import android.app.Application

class ConfiguracionInicial: Application() {

    companion object{
        lateinit var preferenciasGlobal: Preferencias
    }

    override fun onCreate() {
        super.onCreate()

        //Este obj ya puede ser accedido en cualquier parte de la app
        preferenciasGlobal = Preferencias(applicationContext)
    }
}