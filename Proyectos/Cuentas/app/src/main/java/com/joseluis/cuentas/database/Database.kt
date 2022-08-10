package com.joseluis.cuentas.database

import com.joseluis.cuentas.models.Cliente
import com.joseluis.cuentas.models.Cuenta
import com.joseluis.cuentas.models.ClenteCuentas

object Database {
    val OPERACION_KEY = "OPERACION"
    val OPERACION_INSERTAR = "INSERTAR"
    val OPERACION_EDITAR   = "EDITAR"
    val OPERACION_ELIMINAR = "ELIMINAR"

    val TIPOS_CUENTA = arrayOf("Débito","Crédito")
    val TIPO_DEBITO = TIPOS_CUENTA[0]
    val TIPO_CREDITO = TIPOS_CUENTA[1]

    val clientes = ArrayList<Cliente>()
    var clientesCuentas = ArrayList<ClenteCuentas>()

    var ids = 0..1500
    var saldos = 0..1000000

    fun agregarCuenta(mCliente: Cliente,mCuenta: Cuenta):Boolean{
        var nuevoRegistro = ClenteCuentas()
        nuevoRegistro.mCliente  = mCliente
        nuevoRegistro.mCuenta   = mCuenta
        //clientes.add(mCliente)
        return clientesCuentas.add(nuevoRegistro)
    }

    fun eliminarCuenta(posicion:Int):Boolean{
        var registroARemover:ClenteCuentas = clientesCuentas[posicion]
        return clientesCuentas.remove(registroARemover)
    }

    fun editarCuenta(posicion:Int,mCliente:Cliente,mCuenta:Cuenta):Boolean{
        var itemsIniciales = clientesCuentas.size
        var obj = clientesCuentas[posicion]
        obj.mCliente = mCliente
        obj.mCuenta  = mCuenta;
        clientesCuentas[posicion] = obj
        var itemsFinales = clientesCuentas.size

        return (itemsFinales == itemsIniciales)
    }

    fun obtenerBaseDatos():ArrayList<ClenteCuentas>{
        if(clientesCuentas.size>0){
            return clientesCuentas
        }
        else{
            //generamos 5 clientes
            for(i in 1..5){
                var mCliente = Cliente()
                mCliente.idCliente  = i
                mCliente.nombre     = "Cliente $i"
                //creamos las cuentas del cliente
                for(c in 0..1){
                    var mCuenta = Cuenta()
                    mCuenta.idCuenta    = ids.random()
                    mCuenta.numero      = ids.random().toLong()
                    mCuenta.saldo       = saldos.random().toDouble()
                    mCuenta.tipo        = TIPOS_CUENTA[c]
                    mCliente.cuentas.add(mCuenta)
                }
                clientes.add(mCliente)
            }

            //genermos el data set cliente cuenta
            clientes.forEach {
                var objCliente = it
                it.cuentas.forEach {
                    var item = ClenteCuentas()
                    item.mCliente   = objCliente
                    item.mCuenta    = it
                    clientesCuentas.add(item)
                }
            }
            return clientesCuentas
        }
    }

    fun obtenerClients():ArrayList<Cliente>{
        return clientes
    }
}