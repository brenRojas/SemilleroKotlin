package com.brenda.demoretrofit.config

import android.app.Application
import com.brenda.demoretrofit.apis.ApiWeb

class InicioApplication:Application() {

    companion object{
        lateinit var webServiceGlobal: ApiWeb
    }

    override fun onCreate() {
        super.onCreate()

        //Este obj ya puede ser accedido en cualquier parte de la app
        webServiceGlobal = RetrofitApis().obtenerConfiguracionRetrofit()
    }

}