package com.brenda.demotesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brenda.demotesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun evento(view: android.view.View) {
        when(view.id){
            R.id.btnOperacion ->{
                binding.txtNombre.setText("Bren")
                throw RuntimeException("Error en el tiempo de ejecució simulado")
            }
        }
    }
}