package com.brenda.demoroom.interfaces

interface DialogListener {
    fun abrirDialogo()
    fun eliminarDialogo(posicion:Int)
    fun editarDialogo(id:Int)

    fun addUser(firstName:String, lastName:String, age:Int)
    fun deleteUser(uid:Int)
    fun editUser(id: Int, firstName: String, lastName: String, age: Int)
}