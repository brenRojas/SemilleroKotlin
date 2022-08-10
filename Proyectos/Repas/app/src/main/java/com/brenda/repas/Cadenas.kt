package com.brenda.repas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Cadenas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadenas)

        cadena()

    }

}


fun cadena(){
    var cadena = "Este es el texto del reto de lógica. Con esto van a mejorar su razonamiento"
    var arreglo = cadena.split(" ")
    var palabraLarga = ""
    var auxLarga = 0
    var auxCorta = 0
    var palabraCorta = ""
    var auxPalabra = arreglo[0]

    println(arreglo)

    //1. la palabra más larga
    arreglo.forEach{
        if(it.length > auxLarga ){
            auxLarga = it.length
            palabraLarga = it
        }
    }
    println(palabraLarga)


    //2. La palabra más corta
    auxCorta = palabraLarga.length
    arreglo.forEach{
        if(it.length < auxCorta ){
            auxCorta = it.length
            palabraCorta = it
        }
    }
    println(palabraCorta)


    //3. La palabra que más se repite
    println(auxPalabra)
    arreglo.forEach{
    }


}