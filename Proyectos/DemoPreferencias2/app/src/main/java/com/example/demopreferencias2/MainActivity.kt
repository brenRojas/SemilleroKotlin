package com.example.demopreferencias2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demopreferencias2.ConfiguracionInicial.Companion.preferenciasGlobal
import com.example.demopreferencias2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var nombre = binding.txtNombre.text.toString()
            if(nombre.trim().isNotEmpty()){
                preferenciasGlobal.iniciarSesion(nombre, true)
                cambiarActividad()
            }
        }
        if(preferenciasGlobal.validaSesionIniciada()){
            cambiarActividad()
        }
    }

    private fun cambiarActividad() {
        val intento = Intent(applicationContext, BienvenidoActivity::class.java)
        startActivity(intento)
        finish()
    }


}