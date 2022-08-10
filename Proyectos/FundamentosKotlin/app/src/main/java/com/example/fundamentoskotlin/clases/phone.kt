package com.example.fundamentoskotlin.clases

class phone (val number:Int){
    fun call(){
        println("Llamando..")
    }
    fun showNumber(){
        println("Mi número es: $number")
    }
}