package com.brenda.demoroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.demoroom.adapter.UserAdapter
import com.brenda.demoroom.config.UserApp.Companion.basedatos
import com.brenda.demoroom.databinding.ActivityMainBinding
import com.brenda.demoroom.dialog.AddUserDialog
import com.brenda.demoroom.dialog.DeleteUserDialog
import com.brenda.demoroom.dialog.EditUserDialog
import com.brenda.demoroom.interfaces.DialogListener
import com.brenda.demoroom.models.User
import com.brenda.demoroom.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), DialogListener {

    lateinit var binding:ActivityMainBinding
    lateinit var adaptador: UserAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var listaUsuarios = basedatos.userDao().getAll()
        //adaptador = UserAdapter(listaUsuarios, this)

        viewModel = ViewModelProvider(this).get()
        viewModel.getAll(this)
        viewModel.adaptador.observe(this, {
            binding.RecyclerUser.adapter = it
            binding.RecyclerUser.layoutManager = LinearLayoutManager(this)
        })


        binding.btnAgregar.setOnClickListener {
            abrirDialogo()
        }
    }

    override fun abrirDialogo() {
        val newFragment = AddUserDialog(this)
        newFragment.show(supportFragmentManager, "agregar")
    }

    override fun eliminarDialogo(posicion:Int) {
        val newFragment = DeleteUserDialog(this, posicion)
        newFragment.show(supportFragmentManager, "eliminar")
    }

    override fun editarDialogo(posicion: Int) {
        val newFragment = EditUserDialog(this, posicion)
        newFragment.show(supportFragmentManager, "eliminar")
    }

    override fun addUser(firstName: String, lastName: String, age: Int) {
        //var usuario = User(0, firstName, lastName, age)
        //basedatos.userDao().insert(arrayListOf(usuario))
        //adaptador.update(basedatos.userDao().getAll())
        //Toast.makeText(applicationContext, "Usuario ${usuario.firstName} agregado", Toast.LENGTH_SHORT).show()
        var user = User(0, firstName, lastName,age)

        viewModel = ViewModelProvider(this).get()
        viewModel.insert(this, arrayListOf(user))
        //adaptador.update(basedatos.userDao().getAll())
        Toast.makeText(applicationContext, "Usuario ${firstName} agregado", Toast.LENGTH_SHORT).show()

    }


    override fun deleteUser(posicion: Int) {
        var usuarioEliminar = basedatos.userDao().getUserById(posicion)
        //basedatos.userDao().delete(usuarioEliminar)
        //adaptador.update(basedatos.userDao().getAll())
        //Toast.makeText(applicationContext, "Usuario ${posicion} eliminado", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProvider(this).get()
        viewModel.delete(this, usuarioEliminar)
        //adaptador.update(basedatos.userDao().getAll())
        Toast.makeText(applicationContext, "Usuario eliminado", Toast.LENGTH_SHORT).show()
    }

    override fun editUser(id: Int, firstName: String, lastName: String, age: Int) {
        /*
        * var usuarioEditar = User(id, firstName, lastName, age)
        basedatos.userDao().update(usuarioEditar)
        adaptador.update(basedatos.userDao().getAll())
        Toast.makeText(applicationContext, "Usuario actualizado", Toast.LENGTH_SHORT).show()
        * */

        var usuarioEditar = User(id, firstName, lastName, age)
        viewModel = ViewModelProvider(this).get()
        viewModel.update(usuarioEditar)
        Toast.makeText(applicationContext, "Usuario eliminado", Toast.LENGTH_SHORT).show()
    }


}