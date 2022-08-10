package com.brenda.demogpswriter.provider

import com.brenda.demogpswriter.models.Vehiculo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RealtimeProvider {
    private var database: DatabaseReference

    init {
        database = Firebase.database.reference
    }

    fun insertarVehiculo(v : Vehiculo){
        database.child("Vehiculos").setValue(v)
    }

    fun obtenerReferencia() : DatabaseReference{
        return database.child("Vehiculos")
    }

}