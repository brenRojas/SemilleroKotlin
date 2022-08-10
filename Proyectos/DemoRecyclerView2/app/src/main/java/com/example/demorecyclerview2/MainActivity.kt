package com.example.demorecyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demorecyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adaptador: EstadosAdapter
    lateinit var binding: ActivityMainBinding
    lateinit var datos: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datos = listOf(
            "Aguascalientes",
            "Baja California",
            "Baja California Sur",
            "Campeche",
            "Coahuila",
            "Colima",
            "Chiapas",
            "Chihuahua",
            "Durango",
            "Distrito Federal",
            "Guanajuato",
            "Guerrero",
            "Hidalgo",
            "Jalisco",
            "México",
            "Michoacán",
            "Morelos",
            "Nayarit",
            "Nuevo León",
            "Oaxaca",
            "Puebla",
            "Querétaro",
            "Quintana Roo",
            "San Luis Potosí",
            "Sinaloa",
            "Sonora",
            "Tabasco",
            "Tamaulipas",
            "Tlaxcala",
            "Veracruz",
            "Yucatán",
            "Zacatecas"
        )

        var adaptador = EstadosAdapter(datos)
        binding.myRecyclerView.adapter = adaptador
        binding.myRecyclerView.apply {
            //layoutManager = LinearLayoutManager(applicationContext)
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, true)

            //True reversa, false cierto
            //layoutManager = GridLayoutManager(applicationContext, 2, GridLayoutManager.VERTICAL, true)
        }

        binding.txtBuscar.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //var filtro = datos.filter{it.contains(s.toString().uppercase()) || it.contains(s.toString().lowercase())}
                var filtro = datos.filter { it.lowercase().contains(s.toString().lowercase()) }
                //Actualizar adaptador
                adaptador.update(filtro)
            }

            override fun afterTextChanged(p0: Editable?) {
                //TODO("Not yet implemented")
            }

        })

    }


}