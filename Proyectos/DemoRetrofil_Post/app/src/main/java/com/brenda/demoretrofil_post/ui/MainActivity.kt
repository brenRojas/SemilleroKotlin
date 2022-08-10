package com.brenda.demoretrofil_post.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.demoretrofil_post.R
import com.brenda.demoretrofil_post.config.PublicacionAdapter
import com.brenda.demoretrofil_post.config.RetrofitConfig
import com.brenda.demoretrofil_post.config.inicioAplicacion.Companion.webServiceGlobal
import com.brenda.demoretrofil_post.databinding.ActivityMainBinding
import com.brenda.demoretrofil_post.models.Publicacion
import com.brenda.demoretrofil_post.models.Todos
import com.brenda.demoretrofil_post.models.Users
import com.brenda.demoretrofil_post.providers.JsonPlaceHolderProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), JsonPlaceHolderProvider {

    lateinit var datos: ArrayList<Publicacion>
    lateinit var binding: ActivityMainBinding
    var publicaciones: RetrofitConfig = RetrofitConfig()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarPublicaciones()
        insertarPublicacion()
        recuperarPublicacion(100)
    }

    fun recuperarPublicacion(idPublicacion: Int){
        var callRespuesta = webServiceGlobal.getPostById(idPublicacion)
        callRespuesta?.enqueue(object : Callback<Publicacion>{
            override fun onResponse(call: Call<Publicacion>, response: Response<Publicacion>) {
                if(response.isSuccessful){
                    if (response.body()!=null){
                        val publicacion = response.body()!!
                        var mensaje = "id = ${publicacion.id}"
                        mensaje += "\ntitle = ${publicacion.title}"
                        mensaje += "\nbody = ${publicacion.body}"
                        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<Publicacion>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    fun recuperarPublicaciones(){
        var callRespuesta = webServiceGlobal.recuperaPublicaciones()
        callRespuesta.enqueue(object: Callback<ArrayList<Publicacion>>{
            override fun onResponse(
                call: Call<ArrayList<Publicacion>>,
                response: Response<ArrayList<Publicacion>>
            ) {
                //El Servidor si responde algo
                if(response.isSuccessful){
                    val listaConsumida = response.body()
                    if(listaConsumida != null && listaConsumida.size>0){
                       /* listaConsumida.forEach{
                            var id = it.id
                            var title = it.title

                            Log.d("Mensaje","El id es $id. Título: $title")
                        }*/
                        var adaptador = PublicacionAdapter(listaConsumida)
                        binding.myRecycler.adapter = adaptador
                        binding.myRecycler.layoutManager = LinearLayoutManager(applicationContext)
                    }
                }else{
                    Toast.makeText(applicationContext, "Lista vacía", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<Publicacion>>, t: Throwable) {
                //Sucede cuando son errores 500, la petición falla
                Toast.makeText(applicationContext, "Falló petición al servidor", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun insertarPublicacion(){
        var mPublicacion = Publicacion(50, 0, "titulo_Brenda", "Cuerpo de la nueva publicacion")
        var callRespuesta = webServiceGlobal.insertarPublicacion(mPublicacion)

        callRespuesta.enqueue(object : Callback<Publicacion>{
            override fun onResponse(call: Call<Publicacion>, response: Response<Publicacion>) {
                var publicacionNueva:Publicacion = response.body()!!
                var mensaje = "Publicacion creada con el id ${publicacionNueva.id}"
                mensaje += "\n titulo ${publicacionNueva.title}"
                mensaje += "\n id ${publicacionNueva.id}"
                mensaje += "\n body ${publicacionNueva.body}"


                if (response.isSuccessful){
                    Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext, "No se inserto ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Publicacion>, t: Throwable) {
                Toast.makeText(applicationContext, "Falló petición al servidor", Toast.LENGTH_SHORT).show()

            }

        })
    }

    override fun recuperaPublicaciones(): Call<ArrayList<Publicacion>> {
        TODO("Not yet implemented")
    }

    override fun insertarPublicacion(body: Publicacion): Call<Publicacion> {
        TODO("Not yet implemented")
    }

    override fun getPostById(idPublicacion: Int): Call<Publicacion>? {
        TODO("Not yet implemented")
    }

    override fun mostrarTodos(): Call<ArrayList<Todos>> {
        TODO("Not yet implemented")
    }

    override fun mostrarUsers(): Call<ArrayList<Users>> {
        TODO("Not yet implemented")
    }


}