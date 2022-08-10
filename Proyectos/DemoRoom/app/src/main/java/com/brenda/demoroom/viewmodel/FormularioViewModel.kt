package com.brenda.demoroom.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormularioViewModel: ViewModel() {

    var correo = MutableLiveData<String>()
    var edad = MutableLiveData<Int>()
    var band = MutableLiveData<Boolean>()

    init {
        edad.value = 10
    }

    fun guardarInformacion(){
        Log.d("Mensaje", "Correo: ${correo.value}")
        Log.d("Mensaje", "Edad: ${edad.value}")

        band.value = true
    }

}