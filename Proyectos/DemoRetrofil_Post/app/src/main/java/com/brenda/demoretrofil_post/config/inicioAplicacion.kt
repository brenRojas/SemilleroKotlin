package com.brenda.demoretrofil_post.config

import android.app.Application
import com.brenda.demoretrofil_post.providers.JsonPlaceHolderProvider

class inicioAplicacion:Application() {

    companion object{
        lateinit var webServiceGlobal: JsonPlaceHolderProvider
    }

    override fun onCreate() {
        super.onCreate()
        webServiceGlobal = RetrofitConfig().obtenerConfiguracionRetrofit()
    }
}