package com.example.reto_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.Toast
import com.example.reto_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.confirmar.setOnClickListener{
            val Nombre = binding.nombre.text.toString()
            val Edad = binding.edad.text.toString()
            val mensaje = "Nombre: $Nombre, edad: $Edad"
            Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
        }
    }


}

