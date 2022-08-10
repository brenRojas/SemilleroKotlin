package com.example.demowidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.demowidgets.databinding.ActivityRetoParte1Binding

class RetoParte1 : AppCompatActivity() {

    lateinit var binding: ActivityRetoParte1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetoParte1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.siguiente.setOnClickListener{
            mostrarDatos()
        }
    }

    fun mostrarDatos() {
        when {
            binding.imagen.isVisible -> {
                binding.imagen.isVisible = false
                binding.imagen2.isVisible = true
            }
            binding.imagen2.isVisible -> {
                binding.imagen2.isVisible = false
                binding.check.isVisible = true
            }
            binding.check.isChecked -> {
                val intento = Intent(this, RetoParte2::class.java)

                ////////////////////////////////////////////////////////////////

                //Extras, envío de datos entre actividades
                intent.putExtra("Nombre", "Pablito")

                ////////////////////////////////////////////////////////////////

                startActivity(intento)
                finish()
            }
            else -> {
                val intento = Intent(this, RetoParte2::class.java)
                startActivity(intento)
            }
        }
    }
}