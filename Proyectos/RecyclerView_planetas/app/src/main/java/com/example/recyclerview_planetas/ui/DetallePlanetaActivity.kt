
package com.example.recyclerview_planetas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview_planetas.R
import com.example.recyclerview_planetas.dao.PlanetasDao
import com.example.recyclerview_planetas.databinding.ActivityDetallePlanetaBinding

class DetallePlanetaActivity : AppCompatActivity() {
    companion object{
        var PLANETA_NAME = "PLANETA_NAME"
        var PLANETA_IMAGE = "PLANETA_IMAGE"
        var PLANETA_DESCRIPCION = "PLANETA_DESCRIPCION"
    }

    lateinit var binding: ActivityDetallePlanetaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePlanetaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra(PlanetasDao.PLANETA_NAME)
        val descripcion = intent.getStringExtra(PlanetasDao.PLANETA_DESCRIPCION)
        val imagen = intent.getIntExtra(PlanetasDao.PLANETA_IMAGE, 0)

        with(binding){
            txtPlaneta.text = nombre
            txtDescripcion.text = descripcion
            imgPlaneta.setImageResource(imagen)
        }
    }
}