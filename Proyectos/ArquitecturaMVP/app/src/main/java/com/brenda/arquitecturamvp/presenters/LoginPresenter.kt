package com.brenda.arquitecturamvp.presenters

import com.brenda.arquitecturamvp.models.LoginModel
import com.brenda.arquitecturamvp.views.LoginViewListener

class LoginPresenter(val vista: LoginViewListener):LoginPresenterListener {

    val modelo = LoginModel(this)

    override fun iniciarSesion(user: String, password: String) {
        if(user.trim().isEmpty() || password.trim().isEmpty()){
            vista.onLoginFail("El user o password son requeridos", 1)
        }else{
            modelo.validarUsuario(user, password)
        }
    }

    override fun onLoginExitoso(user: String, telefono: String, password: String) {
        vista.onLoginSuccess("Bienvenido $user. Teléfono $telefono")
    }

    override fun onLoginNoExitoso(razon: String, code: Int) {
        vista.onLoginFail("Error", 1)

    }
}