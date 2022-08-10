package com.brenda.repasodialoglistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() , DialogoListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        abrirDialogo()
    }

    fun abrirDialogo(){
        val newFragment = FireMissilesDialogListener(this)
        newFragment.show(supportFragmentManager, "Misiles")
    }

    override fun siDisparar(motivo: String) {
        Toast.makeText(applicationContext, motivo, Toast.LENGTH_SHORT).show()
    }

    override fun noDisparar(motivo: String) {
        Toast.makeText(applicationContext, motivo, Toast.LENGTH_SHORT).show()
    }
}