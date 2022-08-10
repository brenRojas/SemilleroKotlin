package com.brenda.examenretrofit.providers

import com.brenda.examenretrofit.models.Inmuebles
import com.brenda.examenretrofit.models.Recomendaciones
import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceHolderProvider {
    //Extraer Datos
    @GET("api/Inmueble/Recomendaciones")
    fun RecuperarPostPorId(@Query("Id_Inmueble") Id_Inmueble:Int):Call<Recomendaciones>
}