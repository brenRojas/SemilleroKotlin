package com.brenda.demomvpretrofit_perros.config

import android.app.Application
import com.brenda.demomvpretrofit_perros.apis.DogsApi

class InicioApplication: Application() {

    companion object{
        lateinit var webServiceGlobal: DogsApi
    }

    override fun onCreate() {
        super.onCreate()

        webServiceGlobal = RetrofitConfig().obtenerConfiguracionRetrofit()
    }

}