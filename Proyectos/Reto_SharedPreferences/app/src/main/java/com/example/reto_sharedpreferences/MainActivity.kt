package com.example.reto_sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.reto_sharedpreferences.ConfiguracionInicial.Companion.preferenciasGlobal
import com.example.reto_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSiguiente.setOnClickListener {
            //cambiarImagen(it.id)
                    if (binding.imgSol.visibility == View.VISIBLE) {
                        binding.imgSol.visibility == View.INVISIBLE
                        binding.imgLuna.visibility == View.VISIBLE
                        binding.chkMostrar.visibility == View.INVISIBLE
                    } else if (binding.imgLuna.visibility == View.VISIBLE) {
                        binding.imgSol.visibility == View.INVISIBLE
                        binding.imgLuna.visibility == View.INVISIBLE
                        binding.chkMostrar.visibility == View.VISIBLE
                    } else if (binding.chkMostrar.visibility == View.VISIBLE) {
                        if (binding.chkMostrar.isChecked == true) {
                            preferenciasGlobal.validaSesionIniciada()
                        }
                        cambiarActividad()
                    }

        }
    }

    private fun cambiarActividad() {
        val intento = Intent(applicationContext, Bienvenido::class.java)
        startActivity(intento)
        finish()
    }
}