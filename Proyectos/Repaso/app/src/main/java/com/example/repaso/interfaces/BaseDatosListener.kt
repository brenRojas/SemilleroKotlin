package com.example.repaso.interfaces

interface BaseDatosListener {
    //simular consulta
    fun selectAll(listaPersonas:ArrayList<String>)
    fun deleteAll(listaPersonas: ArrayList<String>)
}