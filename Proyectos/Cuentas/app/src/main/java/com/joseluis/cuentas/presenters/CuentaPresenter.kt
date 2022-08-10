package com.joseluis.cuentas.presenters

import com.joseluis.cuentas.dao.CuentasDao
import com.joseluis.cuentas.listenersui.FragmentsViewListener
import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta
import com.joseluis.cuentas.presenters.listeners.CuentaPresenterListener

class CuentaPresenter(private val vista:FragmentsViewListener):CuentaPresenterListener {
    private val mCuentasDao = CuentasDao(this)
    override fun obtenerCuentas() {
        mCuentasDao.consultarCuentasDb()
    }

    override fun onObtenerCuentasSuccess(lista: ArrayList<ClenteCuentas>) {
        vista.onGetListSuccess(lista)
    }

    override fun onObtenerCuentasFail(mensaje: String) {
        vista.onGetListFail(mensaje)
    }

    override fun crearCuenta(mCliente: Cliente, mCuenta: Cuenta) {
        var success = mCuentasDao.agregarCuenta(mCliente,mCuenta)
    }

    override fun onCuentaCreadaSuccess() {
        vista.onCuentaCreadaExito()
    }

    override fun onCuentaCreadaFail() {
        vista.onCuentaCreadaError()
    }

    override fun actualizarCuenta(posicion:Int,mCliente: Cliente, mCuenta: Cuenta) {
        mCuentasDao.editarCuenta(posicion,mCliente,mCuenta)
    }

    override fun onCuentaActualizadaSuccess() {
        vista.onCuentaEditadaExito()
    }

    override fun onCuentaActualizadaFail() {
        vista.onCuentaEditadaError()
    }

    override fun eliminarCuenta(posicion: Int) {
        mCuentasDao.eliminarCuenta(posicion)
    }

    override fun onCuentaEliminadaSuccess() {
        vista.onCuentaEliminadaExito()
    }

    override fun onCuentaEliminadaFail() {
        vista.onCuentaEliminadaFail()
    }
}