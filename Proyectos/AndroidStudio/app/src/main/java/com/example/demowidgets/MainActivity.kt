package com.example.demowidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mes = arrayOf("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre")
        var semana = arrayOf("1", "2", "3", "4")
        var dia = arrayOf (1, 2, 3, 4, 5, 6, 7)

        for(meses in mes){
            for(semanas in semana){
                for(dias in dia){
                    Log.e("Mensaje:", "Mes: $meses, semana: $semanas, dia: $dias")
                }
            }
        }
    }
}