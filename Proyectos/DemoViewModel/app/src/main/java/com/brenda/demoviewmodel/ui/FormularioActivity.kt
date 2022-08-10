package com.brenda.demoviewmodel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

import com.brenda.demoviewmodel.databinding.ActivityFormularioBinding
import com.brenda.demoviewmodel.viewmodels.FormularioViewModel

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

        viewModel.edad.observe(this, {
            if(it < 18){
                binding.txtMayorEdad.text = "No"
            }else{
                binding.txtMayorEdad.text = "Si"
            }
        })

        viewModel.nombre.observe(this, {
            binding.txtDatos.text = it
        })
    }
}