package com.brenda.examenfragments.config

import android.content.Context

class Preferencias(contexto: Context) {
    val BASE_DATOS_KEY = "BD_PREFERENCIAS_DOS"
    val SESSION_KEY = "SESSION_KEY"

    val sharedPreferences = contexto.getSharedPreferences(BASE_DATOS_KEY, Context.MODE_PRIVATE)


    fun iniciarSesion(sesion:Boolean){
        with(sharedPreferences.edit()){
            putBoolean(SESSION_KEY, sesion)
        }
    }

    fun validaSesionIniciada(): Boolean{
        return sharedPreferences.getBoolean(SESSION_KEY, false)
    }

    fun cerrarSesion(){
        //Elimina todo lo que esta guardado
        sharedPreferences.edit().clear()
    }

}