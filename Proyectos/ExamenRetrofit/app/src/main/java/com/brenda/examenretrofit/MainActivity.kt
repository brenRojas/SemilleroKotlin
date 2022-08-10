package com.brenda.examenretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.examenretrofit.Dialog.AgregarInmueble
import com.brenda.examenretrofit.Dialog.DeleteDialog
import com.brenda.examenretrofit.adapter.InmuebleAdapter
import com.brenda.examenretrofit.config.InicioAplicacion
import com.brenda.examenretrofit.config.InicioAplicacion.Companion.webServiceGlobal
import com.brenda.examenretrofit.databinding.ActivityMainBinding
import com.brenda.examenretrofit.models.Inmuebles
import com.brenda.examenretrofit.models.Recomendaciones
import com.brenda.examenretrofit.providers.DialogListener
import com.brenda.examenretrofit.providers.JsonPlaceHolderProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), DialogListener {

    lateinit var adaptador: InmuebleAdapter
    lateinit var lista: ArrayList<Inmuebles>
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        obtenerDatos()

    }

    fun abrirDialogo(view: View) {
        when(view.id){
            R.id.btnAgregar -> {
                val newFragment = AgregarInmueble(this)
                newFragment.show(supportFragmentManager, "agregar")
               // Toast.makeText(applicationContext, "Agregar..", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun obtenerDatos() {
        var callRespuesta = InicioAplicacion.webServiceGlobal.RecuperarPostPorId(1)
        callRespuesta.enqueue(object : Callback<Recomendaciones> {

            override fun onResponse(
                call: Call<Recomendaciones>,
                response: Response<Recomendaciones>
            ) {
                val objeto = response.body()!!
                lista = objeto.datos_obtenidos

                if (lista != null && lista.size > 0) {
                    adaptador = InmuebleAdapter(lista,this@MainActivity)
                    binding.recyclerInmuebles.adapter = adaptador
                    binding.recyclerInmuebles.layoutManager = LinearLayoutManager(applicationContext)
                }else{
                    Toast.makeText(applicationContext, "Lista vacía", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<Recomendaciones>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun abrirDialogo(posicion: Int) {
        val newFragment = DeleteDialog(this, posicion)
        newFragment.show(supportFragmentManager, "delete")
    }

    override fun agregar(inmueble: Inmuebles) {
        lista.add(0, inmueble)
        adaptador.update(lista)
        Toast.makeText(applicationContext, "Elemento Agregado", Toast.LENGTH_SHORT).show()
    }

    override fun borrarItem(posicionBorrar: Int) {
        lista.removeAt(posicionBorrar)
        adaptador.update(lista)
        Toast.makeText(applicationContext, "Elemento Eliminado", Toast.LENGTH_SHORT).show()
    }

}