package com.brenda.examenretrofit.providers

import com.brenda.examenretrofit.models.Inmuebles

interface DialogListener {
    fun abrirDialogo(posicion:Int)
    fun agregar(inmuebles: Inmuebles)
    fun borrarItem(posicionBorrar: Int)
}