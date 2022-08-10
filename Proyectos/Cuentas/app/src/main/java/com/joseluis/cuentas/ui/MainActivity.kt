package com.joseluis.cuentas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joseluis.cuentas.R
import com.joseluis.cuentas.database.Database
import com.joseluis.cuentas.models.ClenteCuentas

class MainActivity : AppCompatActivity() {

    lateinit var lista: ArrayList<ClenteCuentas>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lista = Database.obtenerBaseDatos()
    }
}