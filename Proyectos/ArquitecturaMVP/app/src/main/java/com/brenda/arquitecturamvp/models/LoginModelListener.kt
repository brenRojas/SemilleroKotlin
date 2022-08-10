package com.brenda.arquitecturamvp.models

interface LoginModelListener {
    fun validarUsuario(user:String, password:String)
}