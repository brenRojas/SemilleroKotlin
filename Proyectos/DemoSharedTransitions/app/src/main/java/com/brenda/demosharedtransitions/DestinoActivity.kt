package com.brenda.demosharedtransitions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import com.brenda.demosharedtransitions.databinding.ActivityDestinoBinding

class DestinoActivity : AppCompatActivity() {
    lateinit var binding : ActivityDestinoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fade = Fade()
        val decor: View = window.decorView

        window.enterTransition = fade
    }
}