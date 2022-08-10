package com.brenda.examen1.config

import android.content.Context

class Preferencias(contexto: Context) {
    val BASE_DATOS_KEY = "BD_PREFERENCIAS_DOS"
    val NOMBRE_KEY= "NOMBRE_KEY"
    val MAIL_KEY= "MAIL_KEY"
    val SESSION_KEY = "SESSION_KEY"

    val sharedPref = contexto.getSharedPreferences(BASE_DATOS_KEY,Context.MODE_PRIVATE) //modo privado es igual a 0

    fun guardarDatos(nombre:String, mail:String, sesion:Boolean) {
        with(sharedPref.edit()){
            putString(NOMBRE_KEY, nombre)
            putString(MAIL_KEY, mail)
            putBoolean(SESSION_KEY,sesion)
            commit()
        }
    }

    fun recuperarNombre():String{
        return sharedPref.getString(NOMBRE_KEY, "")!!
    }

    fun recuperarCorreo():String{
        return sharedPref.getString(MAIL_KEY, "")!!
    }

    fun validaSesionIniciada(): Boolean{
        return sharedPref.getBoolean(SESSION_KEY, false)
    }

    fun cerrarSesion(){
        sharedPref.edit().clear()
    }

}