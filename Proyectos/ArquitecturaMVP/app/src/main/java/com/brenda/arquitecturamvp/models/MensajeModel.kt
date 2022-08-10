package com.brenda.arquitecturamvp.models

class MensajeModel:MensajeModelListener {
    override fun conultarMensajeBd(): String {
        //Hace un select y devuelve algo, o consume un API y devuelve algo
        return "Hola bienvenido a Kotlin"
    }
}