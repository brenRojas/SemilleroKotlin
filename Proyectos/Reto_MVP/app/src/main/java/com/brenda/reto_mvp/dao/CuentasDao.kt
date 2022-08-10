package com.brenda.reto_mvp.dao

import com.brenda.reto_mvp.datos.Cuenta

class CuentasDao {

    companion object{
        var CUENTA_ID = "CUENTA_ID"
        var CUENTA_NAME = "CUENTA_NAME"
        var CUENTA_TIPO = "CUENTA_TIPO"
        var CUENTA_SALDO = "CUENTA_SALDO"
    }

    fun obtenerCuentas() : ArrayList<Cuenta>{

        var cuentasUsuario = ArrayList<Cuenta>()

        cuentasUsuario.add(Cuenta(1,"Brenda Rojas", "Debito", 1000,"4152 4252 4252 4252"))
        cuentasUsuario.add(Cuenta(1,"Brenda Rojas", "Credito", 5, "4155 4444 4442 4252"))
        cuentasUsuario.add(Cuenta(1,"Brenda Rojas", "Credito", 500, "4444 5555 5555 4444"))
        cuentasUsuario.add(Cuenta(1,"Brenda Rojas", "Debito", 4000, "1234 1234 1234 1234"))

        return cuentasUsuario
    }


}