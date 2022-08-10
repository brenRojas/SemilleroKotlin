package com.example.demodialogo.interfaces

interface DialogoListener {

    fun onMissileFired(respuesta:String)
    fun onTimeSelected(isSelected:Boolean=false, hora:Int=0, minuto: Int=0)
    fun onListSelected(lista:ArrayList<String>)
    fun onDateSelected(year:Int, month:Int, day:Int)
    fun onSingleSelected(topping:String)
    fun onSignInSuccess(username:String, password:String)

}