package com.brenda.demomvpretrofit_perros.dao.webservices

import android.widget.Toast
import com.brenda.demomvpretrofit_perros.config.InicioApplication
import com.brenda.demomvpretrofit_perros.models.PerroModel
import com.brenda.demomvpretrofit_perros.presenters.DogPresenterListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogWebServices(val presentador:DogPresenterListener) : DogWebServiceListener{


    override fun consumirListaPerros() {
        var callRespuesta = InicioApplication.webServiceGlobal.recuperaListaPorRaza()
        callRespuesta.enqueue(object : Callback<PerroModel> {

            override fun onResponse(
                call: Call<PerroModel>,
                response: Response<PerroModel>
            ) {
                if(response.isSuccessful){
                    val objPerro = response.body()
                    if(objPerro != null){
                        val tam = objPerro.listaPerros.size
                        presentador.consumoExitoso(objPerro.listaPerros)
                    }else{
                        presentador.consumoFallido("Objeto Vacío")
                    }
                }else{
                    presentador.consumoFallido("Response Fail ${response.code()}")
                }
            }

            override fun onFailure(call: Call<PerroModel>, t: Throwable) {
                presentador.consumoFallido(t.message.toString())
            }


        })
    }
}