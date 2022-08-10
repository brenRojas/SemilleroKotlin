package com.brenda.notificacionsybottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brenda.notificacionsybottomnav.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var texto = intent.getStringExtra("nombre")
        if(texto != null){
            binding.txtRecibir.text = texto
        }else{
            binding.txtRecibir.text = "no se recibió nada"
        }

    }
}