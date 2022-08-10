package com.joseluis.cuentas.models

import java.io.Serializable

 class Cuenta:Serializable {
     var idCuenta:Int = 0
     var numero:Long = 0L
     var saldo:Double = 0.0
     var tipo:String = ""
 }