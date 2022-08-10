package com.example.demowidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demowidgets.databinding.ActivityRetoParte2Binding

class RetoParte2 : AppCompatActivity() {

    lateinit var binding: ActivityRetoParte2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetoParte2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ///////////////////////////////////////////////////////////////

        //Recibir un string de otra actividad que puede ser nulo
        val intento:String? = intent.getStringExtra("Nombre")!!
        Toast.makeText(this, intento, Toast.LENGTH_LONG).show()

        ///////////////////////////////////////////////////////////////


        binding.mostrarboton.setOnClickListener{
            var mensaje:String
            mensaje = "Campo 1: ${binding.texto1.text.toString()}. Campo 2: ${binding.texto2.text.toString()}"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}