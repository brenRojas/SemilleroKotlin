package com.example.reto_sharedpreferences

import android.content.Context

class Preferencias (contexto: Context) {
    val MOSTRAR_KEY = "MOSTRAR_KEY"
    val SESSION_KEY = "SESSION_KEY"

    val sharedPreferences = contexto.getSharedPreferences(MOSTRAR_KEY, Context.MODE_PRIVATE)


    fun validaSesionIniciada(): Boolean{
        return sharedPreferences.getBoolean(SESSION_KEY, false)
    }

}