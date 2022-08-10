package com.example.recyclerview_planetas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_planetas.R
import com.example.recyclerview_planetas.adaptadores.PlanetaAdapter
import com.example.recyclerview_planetas.dao.PlanetasDao
import com.example.recyclerview_planetas.databinding.ActivityMainBinding
import com.example.recyclerview_planetas.models.Planeta

class MainActivity : AppCompatActivity() {

    lateinit var datos: ArrayList<Planeta>
    lateinit var binding: ActivityMainBinding
    var daoPlanetas: PlanetasDao = PlanetasDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datos = daoPlanetas.getPlanetList()
        var adaptador = PlanetaAdapter(datos)
        binding.recyclerPlanetas.adapter = adaptador

        binding.recyclerPlanetas.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }

    }
}