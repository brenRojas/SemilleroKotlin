package com.brenda.demoroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.brenda.demoroom.R
import com.brenda.demoroom.databinding.ActivityFormularioBinding
import com.brenda.demoroom.viewmodel.FormularioViewModel

class FormularioActivity : AppCompatActivity() {

    lateinit var binding : ActivityFormularioBinding
    lateinit var viewModel : FormularioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        binding.modelo = viewModel
        binding.lifecycleOwner = this

        viewModel.band.observe(this,{
            if(it){
                Toast.makeText(applicationContext, "true", Toast.LENGTH_SHORT).show()
            }
        })

    }
}