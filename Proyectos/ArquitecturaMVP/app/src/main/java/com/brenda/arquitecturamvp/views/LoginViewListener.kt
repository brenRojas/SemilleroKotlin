package com.brenda.arquitecturamvp.views

interface LoginViewListener {
    fun onLoginSuccess(mensaje:String)
    fun onLoginFail(razon:String, code:Int)
}