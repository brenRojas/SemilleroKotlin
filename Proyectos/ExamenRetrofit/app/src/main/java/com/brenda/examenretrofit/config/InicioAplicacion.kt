package com.brenda.examenretrofit.config

import android.app.Application
import com.brenda.examenretrofit.providers.JsonPlaceHolderProvider

class InicioAplicacion: Application() {

    companion object{
        lateinit var webServiceGlobal: JsonPlaceHolderProvider
    }

    override fun onCreate() {
        super.onCreate()
        webServiceGlobal = RetrofitConfig().obtenerConfiguracionRetrofit()
    }
}