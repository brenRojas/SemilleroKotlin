package com.joseluis.cuentas.models

import java.io.Serializable

class Cliente:Serializable{
    var idCliente:Int = 0
    var nombre:String = ""
    var cuentas:ArrayList<Cuenta> = ArrayList()

    override fun toString(): String {
        return "$idCliente - $nombre"
    }
}