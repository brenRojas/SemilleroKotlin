package com.brenda.repas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlin.random.Random

class Matrices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrices)

        matrices(3)
    }
}

fun matrices(num:Int) {
    var suma = 0
    var numMenor = 0
    var numMayor = 0
    var comparacionMayor = 0
    var comparacionMenor = 0
    val matriz = Array(num) { IntArray(num) }

    //Llenar matriz
    for (i in 0 .. num-1){
        for (j in 0 .. num-1){
            matriz[i][j]=(1..9).random()
        }
    }

    //Imprimir la matriz
    for (i in 0 .. num-1){
        println("")
        for (j in 0 .. num-1){
            print(matriz[i][j])
            print(" ")
        }
    }

    //NUMERO MAYOR
    for (i in 0 .. num-1){
        for (j in 0 .. num-1){
            if(matriz[i][j] > comparacionMayor){
                comparacionMayor = matriz[i][j]
                numMayor = comparacionMayor
            }
            if(j == i){
                //println(matriz[i][j])
                suma += matriz[i][i]
            }
        }
    }

    comparacionMenor = numMayor
    //NUMERO MENOR
    for (i in 0 .. num-1){
        for (j in 0 .. num-1){
            if(matriz[i][j] < comparacionMenor){
                comparacionMenor = matriz[i][j]
                numMenor = comparacionMenor
            }
        }
    }

    //Resultados
    println("\nEl numero mayor es: $numMayor")
    println("\nEl numero menor es: $numMenor")
    println("\nLa suma de la diagonal es: $suma")
}