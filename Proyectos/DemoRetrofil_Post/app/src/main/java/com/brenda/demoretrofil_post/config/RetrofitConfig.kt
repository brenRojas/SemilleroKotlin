package com.brenda.demoretrofil_post.config

import com.brenda.demoretrofil_post.providers.JsonPlaceHolderProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig{
    val URL_BASE = "https://jsonplaceholder.typicode.com/"

    fun obtenerConfiguracionRetrofit(): JsonPlaceHolderProvider{
        var mRetrofit = Retrofit.Builder()
            . baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return mRetrofit.create(JsonPlaceHolderProvider::class.java)
    }
}