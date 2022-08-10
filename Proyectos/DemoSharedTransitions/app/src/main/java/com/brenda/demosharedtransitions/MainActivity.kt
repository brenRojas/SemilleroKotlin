package com.brenda.demosharedtransitions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.brenda.demosharedtransitions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fade = Fade()
        val decor: View = window.decorView
        window.exitTransition = fade

        binding.imgConejito.setOnClickListener {
            val intent  = Intent(applicationContext,DestinoActivity::class.java)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,binding.imgConejito,
                ViewCompat.getTransitionName(binding.imgConejito)!!)

            startActivity(intent,options.toBundle())
        }
    }
}