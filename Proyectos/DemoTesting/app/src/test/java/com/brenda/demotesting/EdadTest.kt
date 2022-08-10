package com.brenda.demotesting

import androidx.core.view.GravityCompat.apply
import com.brenda.demotesting.models.Persona
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class EdadTest {

    lateinit var mEdad : Edad
    var personas = ArrayList<Persona>()


    @Before
    fun inicializar() {
        mEdad = Edad()
    }
    fun getListPersonas() : ArrayList<Persona> {

        personas.add(Persona("Brenda", 22))
        personas.add(Persona("Jose", 20))
        personas.add(Persona("Maria", 26))


        //return personas
        return personas
    }

    @Test
    fun esMayorEdad(){
        getListPersonas()
        assertEquals(true, mEdad.mayorEdad(personas))
    }


}