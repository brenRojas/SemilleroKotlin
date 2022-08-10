package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Guardar y Recuperar información
        sharedPref = this.getSharedPreferences(
            Constantes.BASE_DATOS_KEY, Context.MODE_PRIVATE)
    }

    fun guardarInformacion(nombre:String){
        //Permite modificar el archivo
        var x = sharedPref.edit()

        with (sharedPref.edit()) {
            //Guardar información
            putString(Constantes.NOMBRE_KEY, nombre)
            putBoolean(Constantes.IS_STARTED_KEY, true)
            commit()
        }

    }


}