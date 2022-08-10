package com.example.reto_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto_3.databinding.ActivityFotosBinding
import com.example.reto_3.databinding.ActivityMainBinding

class Fotos : AppCompatActivity() {
    lateinit var binding:ActivityFotosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fotos)
        binding = ActivityFotosBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}