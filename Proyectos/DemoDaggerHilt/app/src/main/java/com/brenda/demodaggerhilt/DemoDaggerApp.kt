package com.brenda.demodaggerhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Durante el tiempo de vida de la aplicacion vamos a utilizar inyeccion de dependencias
//Inyectar
@HiltAndroidApp
class DemoDaggerApp: Application()


/*
class DemoDaggerApp: Application() {

    companion object{
        lateinit var preferenciasGlobal : Preferencias
    }

    override fun onCreate() {
        super.onCreate()

        preferenciasGlobal = Preferencias(applicationContext)

    }

}

* */