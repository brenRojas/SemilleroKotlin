package com.example.demowidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demowidgets.databinding.ActivityFormularioBinding

class formulario : AppCompatActivity() {
    lateinit var binding: ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.btnConfirmar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val edad = binding.etEdad.toString()
            val correo = binding.etCorreo.text.toString()
            val telefono = binding.etTelefono.text.toString()

            val mensaje = "Nombre: $nombre, edad: $edad, correo: $correo, telefono: $telefono"
            Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
        }*/

        with(binding){
            btnConfirmar.setOnClickListener {
                val nombre = etNombre.text.toString()
                val edad = etEdad.toString()
                val correo = etCorreo.text.toString()
                val telefono = etTelefono.text.toString()

                val mensaje = "Nombre: $nombre, edad: $edad, correo: $correo, telefono: $telefono"
                Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
            }
        }



    }
}