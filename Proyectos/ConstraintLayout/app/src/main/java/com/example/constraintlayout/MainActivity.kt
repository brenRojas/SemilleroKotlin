package com.example.constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.constraintlayout.R.id.et_nombre

class MainActivity : AppCompatActivity() {
    lateinit var txtNombre: EditText
    lateinit var txtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre = findViewById(R.id.et_nombre)
        txtPassword = findViewById(R.id.et_password)

    }

    fun iniciar(view: View){
        val nombre = txtNombre.text.toString()
        val password = txtPassword.text.toString()

        if(nombre.isNullOrEmpty() || password.isNullOrEmpty()){
            Toast.makeText(applicationContext, "Ingresa Nombre y Password", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext, "Bienvenido $nombre", Toast.LENGTH_LONG).show()
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }

    }
}