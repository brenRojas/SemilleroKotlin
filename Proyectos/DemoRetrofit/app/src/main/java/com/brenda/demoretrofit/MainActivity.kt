package com.brenda.demoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.brenda.demoretrofit.config.InicioApplication.Companion.webServiceGlobal
import com.brenda.demoretrofit.databinding.ActivityMainBinding
import com.brenda.demoretrofit.models.Comments
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        consumirServicioGet()
    }

    fun consumirServicioGet(){
        var callRespuesta = webServiceGlobal.recuperaComentarios()
        callRespuesta.enqueue(object :Callback<ArrayList<Comments>>{

            override fun onResponse(
                call: Call<ArrayList<Comments>>,
                response: Response<ArrayList<Comments>>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(applicationContext, "Recibido, ok", Toast.LENGTH_SHORT).show()
                    val listaRecibida = response.body()
                    if(listaRecibida != null){
                        listaRecibida.forEach{
                            Log.d("Mensaje", "--------------------------------")
                            Log.d("Mensaje", "PostId = ${it.postId}")
                            Log.d("Mensaje", "Id = ${it.id}")
                            Log.d("Mensaje", "Name = ${it.name}")
                            Log.d("Mensaje", "Email = ${it.email}")
                            Log.d("Mensaje", "Body = ${it.body}")
                            Log.d("Mensaje", "--------------------------------")
                        }
                    }
                }else{
                    Toast.makeText(applicationContext, "estatus code ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<Comments>>, t: Throwable) {
                Toast.makeText(applicationContext, "El servidor ha fallado", Toast.LENGTH_SHORT).show()
            }

        })
    }
}