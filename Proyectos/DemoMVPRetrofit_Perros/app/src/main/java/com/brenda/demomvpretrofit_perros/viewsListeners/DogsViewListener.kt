package com.brenda.demomvpretrofit_perros.viewsListeners

interface DogsViewListener {

    fun onGetDogListSuccess(lista:ArrayList<String>)
    fun onGetDogListFail(mensaje:String)

}