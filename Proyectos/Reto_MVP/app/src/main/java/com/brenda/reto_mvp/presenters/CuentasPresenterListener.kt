package com.brenda.reto_mvp.presenters

import com.brenda.reto_mvp.datos.Cuenta

interface CuentasPresenterListener {
    fun obtenerUsuarios()
    fun onRecibirLista(listaCuentas: ArrayList<Cuenta>)

}