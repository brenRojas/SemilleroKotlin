package com.joseluis.cuentas.listenersui

import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta

interface FragmentsViewListener {
    fun onGetListSuccess(lista:ArrayList<ClenteCuentas>)
    fun onGetListFail(razon:String)
    fun onCuentaCreadaExito()
    fun onCuentaCreadaError()
    fun onCuentaEditadaExito()
    fun onCuentaEditadaError()
    fun onCuentaEliminadaExito()
    fun onCuentaEliminadaFail()
}