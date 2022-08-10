package com.example.demowidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demowidgets.databinding.ActivityFormularioBinding

//Libreria para dejar de utilizar lateinit, sin embargo se encuentra deprecado
//import kotlinx.android.synthetic.main.activity_formulario.*



class Formulario : AppCompatActivity() {


    //Se declara de la sigueinte manera el binding, con el camelCase del XML de la actividad
    lateinit var binding:ActivityFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Otra manera de utilizar widgets sin el R.id...
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BtnConfirmar.setOnClickListener{
            mostrarDatos()
        }

        //Utilizar la libreria de Synthetic para evitar utilizar lateinit var por cada widget creado
        /*binding.BtnConfirmar.setOnClickListener{
            val Nombre = binding.TxtNombre.text.toString()
            val Edad = binding.TxtEdad.text.toString()
            val Correo = binding.TxtCorreo.text.toString()
            val Telefono = binding.TxtTelefono.text.toString()
            var mensaje = "Nombre: $Nombre, Edad: $Edad, Correo: $Correo, Telefono: $Telefono"
            Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
        }*/
    }

    fun mostrarDatos(){
        with(binding){
            //Utilizar la libreria de Synthetic para evitar utilizar lateinit var por cada widget creado
            val Nombre = TxtNombre.text.toString()
            val Edad = TxtEdad.text.toString()
            val Correo = TxtCorreo.text.toString()
            val Telefono = TxtTelefono.text.toString()
            var mensaje = "Nombre: $Nombre, Edad: $Edad, Correo: $Correo, Telefono: $Telefono"
            Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
        }
    }
}