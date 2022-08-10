package com.brenda.demoretrofit.apis

import com.brenda.demoretrofit.models.Comments
import retrofit2.Call
import retrofit2.http.GET

interface ApiWeb {
    //Consulta
    @GET("comments")
    fun recuperaComentarios():Call<ArrayList<Comments>>
}