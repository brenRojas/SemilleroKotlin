package com.brenda.demoviewmodel.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormularioViewModel : ViewModel() {

    var nombre = MutableLiveData<String>()
    var apellido = MutableLiveData<String>()
    var edad = MutableLiveData<Int>()
    var datos = MutableLiveData<String>()
    var mayorEdad = MutableLiveData<String>()

    init{
        edad.value = 16
        mayorEdad.value = "No"
        nombre.value = "Nombre"
    }

    fun mostrarDatos(){
        datos.value = "Nombre: ${nombre.value}. Apellido: ${apellido.value}. Edad:  ${edad.value}"
    }

}