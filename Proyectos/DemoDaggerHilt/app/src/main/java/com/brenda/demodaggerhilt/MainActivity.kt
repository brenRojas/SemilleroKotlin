package com.brenda.demodaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.brenda.demodaggerhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

//Preparamos el main para recibir dependencias inyectadas "@AndroidEntryPoint"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Crea la instancia, sin inicializar "Verifica si preferencias esta preparado para inyectar"
    @Inject lateinit var preferencias : Preferencias
    lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        preferencias.guardarNombre("Bren")
        binding.btnNombre.setOnClickListener { 
            val nombre = preferencias.recuperarNombre()
            Toast.makeText(applicationContext, "Nombre es $nombre", Toast.LENGTH_SHORT).show()
        }
    }
}