package com.example.repaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.repaso.basededatos.PersonasDao
import com.example.repaso.databinding.ActivityMainBinding
import com.example.repaso.interfaces.BaseDatosListener

class MainActivity : AppCompatActivity(), BaseDatosListener {
    lateinit var binding: ActivityMainBinding
    val personasDao = PersonasDao(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDisparar.setOnClickListener {
            personasDao.seleccionaPersonasGuapas()
        }
    }

    override fun selectAll(personas:ArrayList<String>) {
        Toast.makeText(applicationContext, "Tamaño de la Lista = ${personas.size}", Toast.LENGTH_SHORT).show()
    }

    override fun deleteAll(listaPersonas: ArrayList<String>) {
        Toast.makeText(applicationContext, "Eliminar lista", Toast.LENGTH_SHORT).show()
    }
}