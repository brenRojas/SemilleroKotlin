package com.example.recyclerview_exmen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview_exmen.R
import com.example.recyclerview_exmen.databinding.ActivityDetalleActividadBinding
import com.example.recyclerview_planetas.dao.ActividadesDao

class DetalleActividad : AppCompatActivity() {

    companion object{
        var ACTIVIDAD_CATEGORIA = "ACTIVIDAD_CATEGORIA"
        var ACTIVIDAD_NAME = "ACTIVIDAD_NAME"
        var ACTIVIDAD_IMAGE = "ACTIVIDAD_IMAGE"
        var ACTIVIDAD_DESCRIPCION = "ACTIVIDAD_DESCRIPCION"
    }

    lateinit var binding: ActivityDetalleActividadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetalleActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra(ActividadesDao.ACTIVIDAD_NAME)
        val descripcion = intent.getStringExtra(ActividadesDao.ACTIVIDAD_DESCRIPCION)
        val imagen = intent.getIntExtra(ActividadesDao.ACTIVIDAD_IMAGE, 0)

        with(binding){
            txtNombre.text = nombre
            txtDescipcion.text = descripcion
            imgActividad.setImageResource(imagen)
        }
    }
}