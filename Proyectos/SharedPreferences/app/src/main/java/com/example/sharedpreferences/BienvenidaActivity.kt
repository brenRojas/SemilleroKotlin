package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class BienvenidaActivity : AppCompatActivity() {
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        //Guardar y Recuperar información
        sharedPref = this.getSharedPreferences(
            Constantes.BASE_DATOS_KEY, Context.MODE_PRIVATE)

        val nombre = sharedPref.getString(Constantes.NOMBRE_KEY, "Usuario Contento")
        Toast.makeText(applicationContext, "Bienvenida $nombre", Toast.LENGTH_SHORT).show()

    }
}