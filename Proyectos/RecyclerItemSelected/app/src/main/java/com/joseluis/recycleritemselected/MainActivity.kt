package com.joseluis.recycleritemselected

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.joseluis.recycleritemselected.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.miRecycler.layoutManager = LinearLayoutManager(this)
        var adaptador = EstatusAdapter(Estatus.obtenerLista())
        binding.miRecycler.adapter = adaptador
    }
}