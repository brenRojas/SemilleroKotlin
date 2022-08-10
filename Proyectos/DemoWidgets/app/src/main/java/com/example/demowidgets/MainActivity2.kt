package com.example.demowidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    lateinit var grupoUno: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        grupoUno = findViewById(R.id.grupo1)

    }
    fun mostrarLog(mensaje:String){
        Log.d("Mensaje", mensaje)
    }

    fun verificarCheck(view: View){

        val check:CheckBox = findViewById(R.id.chk_uno)
        val sw:Switch = findViewById(R.id.sw_uno)
        val radioSelected = grupoUno.checkedRadioButtonId

        val opcion = when(radioSelected){
            R.id.radUno -> "Radio1"
            R.id.radDos -> "Radio2"
            else -> "Radio3"
        }
        val mensaje = "Check = ${check.isChecked}. Swicht = ${sw.isChecked}. Radio = $opcion"
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }
}