package com.brenda.arquitecturamvp.models

import com.brenda.arquitecturamvp.presenters.LoginPresenterListener

class LoginModel(val presentador:LoginPresenterListener) : LoginModelListener{

    val usuario = "Bren"
    val password = "123456"

    override fun validarUsuario(user: String, password: String) {
        //select * where usuario=usuario and password=password
        var respuesta = (0..1).random()
        if(usuario.equals(this.usuario) && password.equals((this.password))){
            presentador.onLoginExitoso(user, "1234", "12345")
        }else{
            presentador.onLoginNoExitoso("Usuario o password incorrecto", 100)
        }
    }
}