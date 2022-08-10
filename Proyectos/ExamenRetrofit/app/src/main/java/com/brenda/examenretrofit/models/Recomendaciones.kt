package com.brenda.examenretrofit.models

import com.google.gson.annotations.SerializedName

data class Recomendaciones(
    @SerializedName("DATOS_OBTENIDOS") var datos_obtenidos : ArrayList<Inmuebles>,
    @SerializedName("EVENTO") var evento : String,
    @SerializedName("EXITO") var exito : String,
    @SerializedName("ERROR") var error : String
)