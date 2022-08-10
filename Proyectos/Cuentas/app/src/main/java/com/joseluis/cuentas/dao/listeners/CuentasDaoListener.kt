package com.joseluis.cuentas.dao.listeners

import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta

interface CuentasDaoListener {
    fun consultarCuentasDb()
    fun agregarCuenta(mCliente: Cliente, mCuenta: Cuenta)
    fun eliminarCuenta(posicion:Int)
    fun editarCuenta(posicion:Int,mCliente:Cliente,mCuenta:Cuenta)
}