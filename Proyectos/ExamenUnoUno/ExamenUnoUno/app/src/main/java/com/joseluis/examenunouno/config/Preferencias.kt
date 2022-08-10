package com.joseluis.examenunouno.config

import android.content.Context

class Preferencias(contexto: Context) {
    val BASE_DATOS_KEY = "BD_PREFERENCIAS_DOS"
    val SESSION_KEY = "SESSION_KEY"

    // EL SEGUNDO PARÁMETRO INDICA LA VISIBILIDAD DEL ARCHIVO DE "BASE DE DATOS"
    val sharedPref = contexto.getSharedPreferences(BASE_DATOS_KEY, Context.MODE_PRIVATE)

    fun iniciarSesion(sesion:Boolean){
        with(sharedPref.edit()){
            putBoolean(SESSION_KEY,sesion)
            commit()
        }
    }

    fun validaSesionIniciada():Boolean{
        return sharedPref.getBoolean(SESSION_KEY,false)
    }

    fun cerrarSesion(){
        //BORRA TODO LO QUE ESTA GUARDADO
        sharedPref.edit().clear().apply()
    }

}