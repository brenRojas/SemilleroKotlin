package com.brenda.demoroom.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditarViewModel : ViewModel(){

    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
    var age = MutableLiveData<Boolean>()

}