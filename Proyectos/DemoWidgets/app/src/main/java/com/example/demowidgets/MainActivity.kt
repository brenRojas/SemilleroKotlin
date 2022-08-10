package com.example.demowidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var etContador:EditText
    lateinit var btnSiguiente: Button
    var contador:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mostrarLog("onCreate")

        etContador = findViewById(R.id.et_contador)
        btnSiguiente = findViewById(R.id.btnSiguiente)
        btnSiguiente.setOnClickListener {
            //val intent = Intent(this, MainActivity2::class.java)
            //startActivity(intent)
            //finish()
            contador ++
            etContador.setText("$contador")
        }

    }

    override fun onStop() {
        super.onStop()
        mostrarLog("OnStop")
    }

    override fun onPause() {
        super.onPause()
        mostrarLog("OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarLog("OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        mostrarLog("OnDestroy")
    }

    fun mostrarLog(mensaje:String){
        Log.d("Mensaje", mensaje)
    }
}