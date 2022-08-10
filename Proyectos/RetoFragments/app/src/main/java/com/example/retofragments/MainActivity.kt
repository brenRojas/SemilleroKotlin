package com.example.retofragments

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.retofragments.databinding.ActivityMainBinding
import com.example.retofragments.databinding.FragmentFormularioBinding
import com.example.retofragments.ui.FormularioFragment
import com.example.retofragments.ui.TrueFragment
import android.content.Intent
import android.content.SharedPreferences
import com.example.retofragments.ConfiguracionInicial.Companion.preferenciasGlobal


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        val formulario = FormularioFragment()
        val chk = TrueFragment()

        transaction.replace(R.id.contenedor, formulario)
        transaction.commit()
        if(preferenciasGlobal.validaSesionIniciada()){
            cambiarFragment(false)
        }else{
            cambiarFragment(true)
        }

    }

    fun cambiarFragment(boolean:Boolean){
        val newFragment = when(boolean){
            true -> {
                TrueFragment()
            }else -> {
                FormularioFragment()
            }
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedor, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}