package com.brenda.demoretrofil_post.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.demoretrofil_post.R
import com.brenda.demoretrofil_post.config.PublicacionAdapter
import com.brenda.demoretrofil_post.config.RetrofitConfig
import com.brenda.demoretrofil_post.config.TodosAdapter
import com.brenda.demoretrofil_post.config.inicioAplicacion
import com.brenda.demoretrofil_post.config.inicioAplicacion.Companion.webServiceGlobal
import com.brenda.demoretrofil_post.databinding.ActivityMain2Binding
import com.brenda.demoretrofil_post.databinding.ActivityMainBinding
import com.brenda.demoretrofil_post.models.Publicacion
import com.brenda.demoretrofil_post.models.Todos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding
    lateinit var datos: ArrayList<Todos>
    var publicaciones: RetrofitConfig = RetrofitConfig()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarTodos()
    }

    private fun recuperarTodos() {
        var callRespuesta = webServiceGlobal.mostrarTodos()
        callRespuesta.enqueue(object : Callback<ArrayList<Todos>>{
            override fun onResponse(
                call: Call<ArrayList<Todos>>,
                response: Response<ArrayList<Todos>>
            ) {
                //El Servidor si responde algo

                if(response.isSuccessful) {
                    val listaTodos = response.body()
                    if (listaTodos != null && listaTodos.size > 0) {
                        var adaptador = TodosAdapter(listaTodos)
                        binding.recyclerTodos.adapter = adaptador
                        binding.recyclerTodos.layoutManager =
                          LinearLayoutManager(applicationContext)
                    }

                }else{
                    Toast.makeText(applicationContext, "Lista vacía", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ArrayList<Todos>>, t: Throwable) {
                Toast.makeText(applicationContext, "Falló petición al servidor", Toast.LENGTH_SHORT).show()
            }

        })
    }
}