package com.brenda.examenretrofit.models

import com.google.gson.annotations.SerializedName

data class Inmuebles(
    @SerializedName("Recomendacion_Nombre") var nombre : String,
    @SerializedName("Recomendacion_Categoria") var categoria : String,
    @SerializedName("Recomendacion_Direccion") var direccion : String,
    @SerializedName("Recomendacion_Latitud") var latitud : String,
    @SerializedName("Recomendacion_Longitud") var longitud : String,
    @SerializedName("Recomendacion_Imagen") var imagen : String,
    ) {}