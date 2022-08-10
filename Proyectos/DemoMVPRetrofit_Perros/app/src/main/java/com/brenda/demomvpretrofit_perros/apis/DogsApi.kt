package com.brenda.demomvpretrofit_perros.apis

import com.brenda.demomvpretrofit_perros.models.PerroModel
import retrofit2.Call
import retrofit2.http.GET

interface DogsApi {
    //Consulta
    @GET("api/breed/schnauzer/images")
    fun recuperaListaPorRaza(): Call<PerroModel>
}