package com.brenda.arquitecturamvp.presenters

import com.brenda.arquitecturamvp.views.LoginViewListener

interface LoginPresenterListener {
    fun iniciarSesion(user:String, password:String)
    fun onLoginExitoso(user:String, telefono:String, password: String)
    fun onLoginNoExitoso(razon:String, code:Int)
}