package com.brenda.agenda.interfaces

interface DialogoListener {

    fun onDeleteContact(s: String)
    fun onCallContact(s: String)

    fun abrirDialogo(posicion:Int)
    fun borrarItem(posicion: Int)
}