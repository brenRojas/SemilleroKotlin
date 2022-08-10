package com.brenda.demomvpretrofit_perros.presenters

import com.brenda.demomvpretrofit_perros.dao.webservices.DogWebServices
import com.brenda.demomvpretrofit_perros.models.PerroModel
import com.brenda.demomvpretrofit_perros.viewsListeners.DogsViewListener

class DogPresenter(val vista:DogsViewListener) : DogPresenterListener{

    val mModel = DogWebServices(this)

    override fun consumirListaPerros() {
        mModel.consumirListaPerros()
    }

    override fun consumoExitoso(lista: ArrayList<String>) {
        vista.onGetDogListSuccess(lista)
    }

    override fun consumoFallido(mensaje: String) {
        vista.onGetDogListFail(mensaje)
    }
}