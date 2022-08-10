package com.brenda.demoretrofil_post.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.demoretrofil_post.R
import com.brenda.demoretrofil_post.config.TodosAdapter
import com.brenda.demoretrofil_post.config.UsersAdapter
import com.brenda.demoretrofil_post.config.inicioAplicacion
import com.brenda.demoretrofil_post.databinding.ActivityUsersBinding
import com.brenda.demoretrofil_post.models.Todos
import com.brenda.demoretrofil_post.models.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersActivity : AppCompatActivity() {
    lateinit var binding:ActivityUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recuperarUsers()
    }


    private fun recuperarUsers() {
        var callRespuesta = inicioAplicacion.webServiceGlobal.mostrarUsers()
        callRespuesta.enqueue(object : Callback<ArrayList<Users>> {
            override fun onResponse(
                call: Call<ArrayList<Users>>,
                response: Response<ArrayList<Users>>
            ) {
                Toast.makeText(applicationContext, "Funciona :)", Toast.LENGTH_SHORT).show()
                if(response.isSuccessful) {
                    val listaUsers = response.body()
                    if (listaUsers != null && listaUsers.size > 0) {
                        var adaptador = UsersAdapter(listaUsers)
                        binding.usersRecycler.adapter = adaptador
                        binding.usersRecycler.layoutManager =
                            LinearLayoutManager(applicationContext)
                    }

                }else{
                    Toast.makeText(applicationContext, "Lista vacía", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<Users>>, t: Throwable) {
                Toast.makeText(applicationContext, "No funciona :(", Toast.LENGTH_SHORT).show()
            }


        })
    }
}