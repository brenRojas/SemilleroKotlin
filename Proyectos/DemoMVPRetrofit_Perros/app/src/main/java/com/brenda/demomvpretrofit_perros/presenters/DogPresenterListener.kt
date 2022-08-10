package com.brenda.demomvpretrofit_perros.presenters

interface DogPresenterListener {
    fun consumirListaPerros()
    fun consumoExitoso(lista:ArrayList<String>)
    fun consumoFallido(mensaje:String)
}