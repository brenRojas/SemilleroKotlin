package com.example.retoplanetas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retoplanetas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var planetas: List<String>
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        planetas = listOf(
            "Mercurio",
            "Venus",
            "Tierra",
            "Marte",
            "Jupiter",
            "Saturno",
            "Urano",
            "Neptuno",
            "Plutón"
        )

    }
}