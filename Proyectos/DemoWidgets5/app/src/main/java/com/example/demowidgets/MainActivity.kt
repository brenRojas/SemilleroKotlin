package com.example.demowidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    val tag:String = MainActivity::getLocalClassName.toString()
    lateinit var siguiente:Button
    lateinit var etContador:EditText
    var contador:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mostrarLog("OnCreate")
        siguiente = findViewById(R.id.btn_Siguiente)
        etContador = findViewById(R.id.Edtext)
        siguiente.setOnClickListener {
            //TODO, sirve para abrir la segunda actividad

            //Cambiar de actividad
            /*val intento = Intent(this,Actividad2::class.java)
            startActivity(intento)
            finish()*/

            //Contador de números
            contador++
            etContador.setText("$contador")
        }
    }

    override fun onStart(){
        super.onStart()
        mostrarLog("OnStart")
    }

    override fun onResume(){
        super.onResume()
        mostrarLog("OnResume")
    }

    override fun onRestart(){
        super.onRestart()
        mostrarLog("OnRestart")
    }

    override fun onPause(){
        super.onPause()
        mostrarLog("OnPause")
    }

    override fun onStop(){
        super.onStop()
        mostrarLog("OnStop")
    }

    //Aveces no se muestran los Logs, es posible verlo o no
    override fun onDestroy(){
        super.onDestroy()
        mostrarLog("OnDestroy")
    }

    fun mostrarLog(mensaje:String){
        Log.d("Mensaje", mensaje)
    }
}

