package com.joseluis.cuentas.presenters.listeners

import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta

interface CuentaPresenterListener {
    fun obtenerCuentas()
    fun onObtenerCuentasSuccess(lista:ArrayList<ClenteCuentas>)
    fun onObtenerCuentasFail(mensaje:String)

    fun crearCuenta(mCliente: Cliente, mCuenta: Cuenta)
    fun onCuentaCreadaSuccess()
    fun onCuentaCreadaFail()

    fun actualizarCuenta(posicion:Int,mCliente: Cliente, mCuenta: Cuenta)
    fun onCuentaActualizadaSuccess()
    fun onCuentaActualizadaFail()

    fun eliminarCuenta(posicion: Int)
    fun onCuentaEliminadaSuccess()
    fun onCuentaEliminadaFail()
}