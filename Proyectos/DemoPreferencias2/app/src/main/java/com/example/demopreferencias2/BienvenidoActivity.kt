
package com.example.demopreferencias2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demopreferencias2.ConfiguracionInicial.Companion.preferenciasGlobal
import com.example.demopreferencias2.databinding.ActivityBienvenidoBinding

class BienvenidoActivity : AppCompatActivity() {
    lateinit var binding: ActivityBienvenidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBienvenidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = preferenciasGlobal.recuperaNombre()
        binding.txtBienvenido.text = nombre
    }

    fun cerrarSesion(view: android.view.View){
        preferenciasGlobal.cerrarSesion()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}