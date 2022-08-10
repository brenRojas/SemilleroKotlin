package com.brenda.demoroom.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brenda.demoroom.adapter.UserAdapter
import com.brenda.demoroom.config.UserApp.Companion.basedatos
import com.brenda.demoroom.interfaces.DialogListener
import com.brenda.demoroom.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel() : ViewModel(){

    lateinit var listaUsuarios:List<User>
    var adaptador = MutableLiveData<UserAdapter>()

    fun getAll(listener: DialogListener){
        viewModelScope.launch {
            listaUsuarios = withContext(Dispatchers.IO){
                basedatos.userDao().getAll()
            }
            if(listaUsuarios.isNotEmpty()){
                adaptador.value = UserAdapter((listaUsuarios as ArrayList<User>), listener)
            }
        }
    }

    fun insert(listener:DialogListener, user : ArrayList<User>){
        viewModelScope.launch {
            basedatos.userDao().insert(user)
        }
        if(listaUsuarios.isNotEmpty()){
            adaptador.value?.update(basedatos.userDao().getAll())
        }
        //adaptador.update(basedatos.userDao().getAll())
    }

    fun update(user:User){
        viewModelScope.launch {
            basedatos.userDao().update(user)
        }
        if(listaUsuarios.isNotEmpty()){
            adaptador.value?.update(basedatos.userDao().getAll())
        }
    }

    fun delete(listener:DialogListener, user: User){
        viewModelScope.launch {
            basedatos.userDao().delete(user)
        }
        if(listaUsuarios.isNotEmpty()){
            adaptador.value?.update(basedatos.userDao().getAll())
        }
    }

}