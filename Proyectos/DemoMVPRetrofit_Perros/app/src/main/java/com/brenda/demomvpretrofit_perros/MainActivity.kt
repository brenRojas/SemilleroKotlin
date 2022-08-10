package com.brenda.demomvpretrofit_perros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.brenda.demomvpretrofit_perros.config.InicioApplication.Companion.webServiceGlobal
import com.brenda.demomvpretrofit_perros.models.PerroModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}