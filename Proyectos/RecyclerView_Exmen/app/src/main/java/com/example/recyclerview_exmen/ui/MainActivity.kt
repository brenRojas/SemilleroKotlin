package com.example.recyclerview_exmen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_exmen.adapter.CategoriaAdapter
import com.example.recyclerview_exmen.databinding.ActivityMainBinding
import com.example.recyclerview_exmen.models.Actividad
import com.example.recyclerview_planetas.dao.ActividadesDao

class MainActivity : AppCompatActivity() {

    lateinit var datos: ArrayList<Actividad>

    lateinit var binding: ActivityMainBinding
    var daoActividades: ActividadesDao = ActividadesDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datos = daoActividades.getListActividades()
        var adaptadorCategoria = CategoriaAdapter(datos)

        binding.RecyclerViewCategorias.adapter = adaptadorCategoria

        binding.RecyclerViewCategorias.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

}