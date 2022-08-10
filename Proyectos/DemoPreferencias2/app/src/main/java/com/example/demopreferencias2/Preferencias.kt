package com.example.demopreferencias2

import android.content.Context

class Preferencias(contexto: Context) {
    val BASE_DATOS_KEY = "BD_PREFERENCIAS_DOS"
    val NOMBRE_KEY = "NOMBRE_KEY"
    val SESSION_KEY = "SESSION_KEY"

    val sharedPreferences = contexto.getSharedPreferences(BASE_DATOS_KEY, Context.MODE_PRIVATE)


    fun iniciarSesion(nombre:String, sesion:Boolean){
        with(sharedPreferences.edit()){
            putString(NOMBRE_KEY, nombre)
            putBoolean(SESSION_KEY, sesion)

        }
    }

    fun recuperaNombre():String{
        return sharedPreferences.getString(NOMBRE_KEY, "")!!
    }

    fun validaSesionIniciada(): Boolean{
        return sharedPreferences.getBoolean(SESSION_KEY, false)
    }

    fun cerrarSesion(){
        //Elimina todo lo que esta guardado
        sharedPreferences.edit().clear()
    }

}