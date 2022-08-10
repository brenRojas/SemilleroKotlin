package com.brenda.demotesting

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class OperacionTest {
    lateinit var mOperacion : Operacion

    @Before
    fun inicializar(){
        mOperacion = Operacion()
    }

    @Test
    fun objetoNulo(){
        assertNotNull(mOperacion)
    }

    @Test
    fun sumaIsSuccess(){
        assertEquals(99, mOperacion.sumaDosEnteros(50, 49))
    }

    @Test
    fun restaIsSuccess(){
        assertEquals(1, mOperacion.restaDosEnteros(50, 49))
    }

    @Test
    fun multiplicarIsSuccess(){
        assertEquals(24, mOperacion.multiplicarDosEnteros(6,4))
    }

    @Test
    fun comprobarEsPar(){
        assertEquals(true, mOperacion.esParImpar(4))
    }

    @Test
    fun raiz() {
        assertEquals(7.0, mOperacion.raiz(49), 0.0)
    }



}