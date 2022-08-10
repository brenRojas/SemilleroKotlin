package com.brenda.reto_mvp.models

import com.brenda.reto_mvp.dao.CuentasDao
import com.brenda.reto_mvp.datos.Cuenta
import com.brenda.reto_mvp.presenters.CuentasPresenterListener

class CuentasModel(val presentador:CuentasPresenterListener) : CuentasModelListener {


    lateinit var datos: ArrayList<Cuenta>
    var datosCuenta: CuentasDao = CuentasDao()

    override fun obtenerListaCuentas() {
        datos = datosCuenta.obtenerCuentas()
        presentador.onRecibirLista(datos)
    }
}