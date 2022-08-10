package com.brenda.demoretrofit.config

import com.brenda.demoretrofit.apis.ApiWeb
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitApis {
    var URL_BASE = "https://jsonplaceholder.typicode.com/"

    fun obtenerConfiguracionRetrofit():ApiWeb{
        var mRetrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return mRetrofit.create(ApiWeb::class.java)
    }

}