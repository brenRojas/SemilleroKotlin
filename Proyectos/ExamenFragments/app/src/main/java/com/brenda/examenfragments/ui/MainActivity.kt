package com.brenda.examenfragments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brenda.examenfragments.R
import com.brenda.examenfragments.config.ConfiguracionInicial.Companion.preferenciasGlobal
import com.brenda.examenfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        val formulario = FormularioFragment()
        val chk = RecyclerFragment()

        transaction.replace(R.id.contenedor, formulario)
        transaction.commit()

        if(preferenciasGlobal.validaSesionIniciada()){
            cambiarFragment("recycler")
        }else{
            cambiarFragment("false")
        }
    }

    fun cambiarFragment(fragmento:String){
        val newFragment = when(fragmento){
            "recycler" -> {
                RecyclerFragment()
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