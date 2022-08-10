package com.joseluis.examenunouno.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.joseluis.examenunouno.R
import com.joseluis.examenunouno.config.ConfiguracionInicial.Companion.preferenciasGlobal
import com.joseluis.examenunouno.databinding.ActivityMainBinding
import com.joseluis.examenunouno.interfaces.FormularioInterface

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(preferenciasGlobal.validaSesionIniciada()){
            cambiarFragment(2)
        }else{
            cambiarFragment(1)
        }
    }

    fun cambiarFragment(opcion:Int,nombre:String = ""){
        if(!nombre.isNullOrEmpty()){
            Toast.makeText(applicationContext, "Nombre es $nombre", Toast.LENGTH_SHORT).show()
        }

        var newFragment =
            when(opcion){
                1 -> FormularioFragment()
                else->ListaFragment()
            }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedor, newFragment)
        //se ejecuta cuando presionamos atras. Muestra el contenido anterior
        transaction.addToBackStack(null)
        transaction.commit()
    }



}