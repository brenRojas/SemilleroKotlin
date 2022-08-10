package com.brenda.demodaggerhilt

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

//Con inject ya esta reconocido en todos lados "@Inject"
class Preferencias @Inject constructor(@ApplicationContext context: Context){

    val ARCHIVO_NAME = "PREFERENCIAS_APP"
    val NOMBRE_KEY = "NOMBRE_KEY"

    val sharedPreferences = context.getSharedPreferences(ARCHIVO_NAME, Context.MODE_PRIVATE)

    fun guardarNombre(nombre:String){
        with(sharedPreferences.edit()){
            putString(NOMBRE_KEY, nombre)
            commit()
        }
    }

    fun recuperarNombre():String{
        return sharedPreferences.getString(NOMBRE_KEY, "").toString()
    }
}

/*
class Preferencias (context:Context){

    val ARCHIVO_NAME = "PREFERENCIAS_APP"
    val NOMBRE_KEY = "NOMBRE_KEY"

    val sharedPreferences = context.getSharedPreferences(ARCHIVO_NAME, Context.MODE_PRIVATE)

    fun guardarNombre(nombre:String){
        with(sharedPreferences.edit()){
            putString(NOMBRE_KEY, nombre)
            commit()
        }
    }

    fun recuperarNombre():String{
        return sharedPreferences.getString(NOMBRE_KEY, "").toString()
    }
}
 */