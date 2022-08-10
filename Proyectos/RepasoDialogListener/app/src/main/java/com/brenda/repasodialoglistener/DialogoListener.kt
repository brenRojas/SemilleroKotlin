package com.brenda.repasodialoglistener

interface DialogoListener {
    fun siDisparar(motivo:String)
    fun noDisparar(motivo: String)
    fun abrirDialogo()
}