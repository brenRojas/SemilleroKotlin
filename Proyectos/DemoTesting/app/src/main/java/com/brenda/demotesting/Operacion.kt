package com.brenda.demotesting

import com.brenda.demotesting.models.Persona
import kotlin.math.sqrt

class Operacion {

    fun sumaDosEnteros(a:Int, b:Int): Int{
        return a.plus(b)
    }

    fun restaDosEnteros(a:Int, b:Int): Int{
        return a.minus(b)
    }

    fun multiplicarDosEnteros(a:Int, b:Int): Int{
        return a.times(b)
    }

    fun esParImpar(a:Int): Boolean{
        return a%2 == 0
    }

    fun raiz(a:Int):Double{
        return sqrt(a.toDouble())
    }

}