package com.brenda.examen1.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Toast
import com.brenda.examen1.Dao.Constantes
import com.brenda.examen1.R
import com.brenda.examen1.config.ConfiguracionInicial
import com.brenda.examen1.config.ConfiguracionInicial.Companion.preferenciasGlobal
import com.brenda.examen1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(preferenciasGlobal.validaSesionIniciada()){
            cambiarActivity()
        }
    }

    fun ingresar(view: View) {
        val nombre =  binding.etName.text.toString()
        val mail =  binding.etEmail.text.toString()
        val sesion =  true

        val intent = Intent(this, FeedActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, nombre)
        }
        startActivity(intent)
        preferenciasGlobal.guardarDatos(nombre, mail, sesion)
    }

    fun cambiarActivity(){
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
    }


}