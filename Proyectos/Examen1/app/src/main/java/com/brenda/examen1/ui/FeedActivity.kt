package com.brenda.examen1.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.examen1.Dao.ImagenesDao
import com.brenda.examen1.R
import com.brenda.examen1.adapter.RecyclerAdapter
import com.brenda.examen1.config.ConfiguracionInicial.Companion.preferenciasGlobal
import com.brenda.examen1.databinding.ActivityFeedBinding
import com.brenda.examen1.model.Imagenes

class FeedActivity : AppCompatActivity() {
    lateinit var sharedPref: SharedPreferences
    lateinit var binding:ActivityFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val transaction = supportFragmentManager.beginTransaction()
        val recyclerFragment = RecyclerFragment()
        transaction.replace(R.id.contenedor, recyclerFragment)
        transaction.commit()
    }
}