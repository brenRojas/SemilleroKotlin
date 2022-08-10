package com.brenda.reto_mvp.views

import com.brenda.reto_mvp.datos.Cuenta

interface UserViewsListener {
    fun obtenerLista(usuarios: ArrayList<Cuenta>)
    fun errorObtenerLista(mensaje :String)
}