package com.example.demonotificacionespush

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.example.demonotificacionespush.databinding.ActivityMainBinding
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun suscribirTemaFCM(view: android.view.View) {
        if(view is CheckBox){
            when(view.id){
                R.id.chkElectronica -> {
                    if(binding.chkElectronica.isChecked){
                        Toast.makeText(applicationContext, "Suscribir a ${binding.chkElectronica.text}", Toast.LENGTH_SHORT).show()
                        FirebaseMessaging.getInstance().subscribeToTopic("Electronica")
                    }else{
                        Toast.makeText(applicationContext, "Desuscribir a ${binding.chkElectronica.text}", Toast.LENGTH_SHORT).show()
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Electronica")
                    }
                }
                R.id.chkVideojuegos -> {
                    if(binding.chkVideojuegos.isChecked){
                        Toast.makeText(applicationContext, "Suscribir a ${binding.chkVideojuegos.text}", Toast.LENGTH_SHORT).show()
                        FirebaseMessaging.getInstance().subscribeToTopic("Videojuegos")
                    }else{
                        Toast.makeText(applicationContext, "Desuscribir a ${binding.chkVideojuegos.text}", Toast.LENGTH_SHORT).show()
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("Videojuegos")
                    }
                }
            }
        }
    }



}