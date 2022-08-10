package com.example.recyclerview_exmen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_exmen.R
import com.example.recyclerview_exmen.adapter.ActividadesAdapter
import com.example.recyclerview_exmen.adapter.CategoriaAdapter
import com.example.recyclerview_exmen.databinding.ActivityMain2Binding
import com.example.recyclerview_exmen.databinding.ActivityMainBinding
import com.example.recyclerview_exmen.models.Actividad
import com.example.recyclerview_planetas.dao.ActividadesDao

class MainActivity2 : AppCompatActivity() {

    //private var datos2: ArrayList
    lateinit var datos: ArrayList<Actividad>
    lateinit var binding: ActivityMain2Binding
    var daoActividades: ActividadesDao = ActividadesDao()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoria = intent.getStringExtra(ActividadesDao.ACTIVIDAD_CATEGORIA)

        datos = daoActividades.getListActividades()
        //Filtrar categorias
        datos = datos.filter { it.categoria.equals(categoria) } as ArrayList<Actividad>
        var adaptadorActividad = ActividadesAdapter(datos)
        binding.RecyclerViewActividades.adapter = adaptadorActividad

        binding.RecyclerViewActividades.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }


    }

}