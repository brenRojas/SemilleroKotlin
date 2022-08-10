package com.brenda.examenretrofit.config

import com.brenda.examenretrofit.providers.JsonPlaceHolderProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig{
    val URL_BASE = "https://www.hostper.rsservidores.xyz/"

    fun obtenerConfiguracionRetrofit(): JsonPlaceHolderProvider {
        var mRetrofit = Retrofit.Builder()
            . baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return mRetrofit.create(JsonPlaceHolderProvider::class.java)
    }
}