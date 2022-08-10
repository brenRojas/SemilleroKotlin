package com.brenda.demoviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.brenda.demoviewmodel.databinding.ActivityMainBinding
import com.brenda.demoviewmodel.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel:MainViewModel

    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()
        binding.txtSumaNormal.text = contador.toString()
        binding.txtSumaViewModel.text = viewModel.contador.toString()

        binding.btnSuma.setOnClickListener {
            contador ++
            binding.txtSumaNormal.text = contador.toString()

            viewModel.contador++
            binding.txtSumaViewModel.text = contador.toString()
        }
    }
}