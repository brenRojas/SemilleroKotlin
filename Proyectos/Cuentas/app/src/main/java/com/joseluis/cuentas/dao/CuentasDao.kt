package com.joseluis.cuentas.dao

import com.joseluis.cuentas.dao.listeners.CuentasDaoListener
import com.joseluis.cuentas.database.Database
import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta
import com.joseluis.cuentas.presenters.listeners.CuentaPresenterListener

class CuentasDao(private val presentador:CuentaPresenterListener):CuentasDaoListener {

    override fun consultarCuentasDb() {
        val cuentasList = Database.obtenerBaseDatos()
        if(cuentasList.size<=0){
            presentador.onObtenerCuentasFail("Lista vacía")
        }
        else{
            presentador.onObtenerCuentasSuccess(cuentasList)
        }
    }

    override fun agregarCuenta(mCliente: Cliente, mCuenta: Cuenta) {
        if(Database.agregarCuenta(mCliente,mCuenta)){
            presentador.onCuentaCreadaSuccess()
        }
        else{
            presentador.onCuentaCreadaFail()
        }
    }

    override fun eliminarCuenta(posicion:Int) {
        if(Database.eliminarCuenta(posicion)){
            presentador.onCuentaEliminadaSuccess()
        }else{
            presentador.onCuentaEliminadaFail()
        }
    }

    override fun editarCuenta(posicion: Int, mCliente: Cliente, mCuenta: Cuenta) {
        if(Database.editarCuenta(posicion,mCliente,mCuenta)){
            presentador.onCuentaActualizadaSuccess()
        }
        else{
            presentador.onCuentaActualizadaFail()
        }
    }

}