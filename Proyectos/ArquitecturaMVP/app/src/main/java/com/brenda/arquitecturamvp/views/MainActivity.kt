package com.brenda.arquitecturamvp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.brenda.arquitecturamvp.R
import com.brenda.arquitecturamvp.databinding.ActivityMainBinding
import com.brenda.arquitecturamvp.presenters.LoginPresenter
import com.brenda.arquitecturamvp.presenters.MensajePresenter
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), LoginViewListener {

    lateinit var binding : ActivityMainBinding
    //lateinit var presentador:MensajePresenter
    lateinit var presentador:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presentador = LoginPresenter(this)
       // presentador.conseguirMensaje()
        with(binding){
            btnLogin.setOnClickListener {
                var user = txtUsuario.text.toString()
                var password = txtPassword.text.toString()
                presentador.iniciarSesion(user, password)
            }
        }
    }

    override fun onLoginSuccess(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFail(razon: String, code: Int) {
        Toast.makeText(applicationContext, "Error: $code. Razón: $razon", Toast.LENGTH_SHORT).show()
    }


    /*override fun saludar(mensaje: String) {
        binding.txtMensaje.text = mensaje
        Snackbar.make(binding.root, mensaje, Snackbar.LENGTH_LONG).show()
        //Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }*/
}