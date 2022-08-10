package com.brenda.demoretrofil_post.providers

import com.brenda.demoretrofil_post.models.Publicacion
import com.brenda.demoretrofil_post.models.Todos
import com.brenda.demoretrofil_post.models.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface JsonPlaceHolderProvider {
    @GET("posts")
    fun recuperaPublicaciones() : Call<ArrayList<Publicacion>>

    @POST("posts")
    fun insertarPublicacion(@Body body:Publicacion):Call<Publicacion>

    //Traer solo un post
    @GET("posts/{id}")
    fun getPostById(@Path("id") idPublicacion: Int): Call<Publicacion>?

    @GET("todos")
    fun mostrarTodos() : Call<ArrayList<Todos>>

    @GET("users")
    fun mostrarUsers() : Call<ArrayList<Users>>
}