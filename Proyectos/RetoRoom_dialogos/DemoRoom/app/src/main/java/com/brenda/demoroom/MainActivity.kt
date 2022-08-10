package com.brenda.demoroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.demoroom.adapter.UserAdapter
import com.brenda.demoroom.config.UserApp.Companion.basedatos
import com.brenda.demoroom.databinding.ActivityMainBinding
import com.brenda.demoroom.dialog.AddUserDialog
import com.brenda.demoroom.dialog.DeleteUserDialog
import com.brenda.demoroom.dialog.EditUserDialog
import com.brenda.demoroom.interfaces.DialogListener
import com.brenda.demoroom.models.User

class MainActivity : AppCompatActivity(), DialogListener {

    lateinit var binding:ActivityMainBinding
    lateinit var adaptador: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listaUsuarios = basedatos.userDao().getAll()
        adaptador = UserAdapter(listaUsuarios, this)

        binding.RecyclerUser.adapter = adaptador
        binding.RecyclerUser.layoutManager = LinearLayoutManager(this)

        binding.btnAgregar.setOnClickListener {
            abrirDialogo()
        }
        /*
        try{
            var usuario = User(3, "Joss", "Nose", 24)
            basedatos.userDao().insert(arrayListOf<User>(usuario))

            var listaUsuarios = basedatos.userDao().getAll()
            listaUsuarios.forEach{
                Log.d("Mensaje", "Id ${it.uid}. Nombre ${it.firstName}")
            }

            var usuarioEditar = User(2, "Adrián", "Gorocica", 26)
            //basedatos.userDao().update(usuarioEditar)

            var usuarioEliminar = basedatos.userDao().getUserById(3)
            //basedatos.userDao().delete(usuarioEliminar)
        }catch (e:Exception){
            Log.e(this.localClassName, "Error ${e.message}")
        }
        */
    }

    override fun abrirDialogo() {
        val newFragment = AddUserDialog(this)
        newFragment.show(supportFragmentManager, "agregar")
    }

    override fun eliminarDialogo(posicion:Int) {
        val newFragment = DeleteUserDialog(this, posicion)
        newFragment.show(supportFragmentManager, "eliminar")
    }

    override fun editarDialogo(id: Int) {
        val newFragment = EditUserDialog(this, id)
        newFragment.show(supportFragmentManager, "editar")
    }

    override fun addUser(firstName: String, lastName: String, age: Int) {
        var usuario = User(0, firstName, lastName, age)
        basedatos.userDao().insert(arrayListOf(usuario))
        adaptador.update(basedatos.userDao().getAll())
        Toast.makeText(applicationContext, "Usuario ${usuario.firstName} agregado", Toast.LENGTH_SHORT).show()
    }

    override fun deleteUser(posicion: Int) {
        var usuarioEliminar = basedatos.userDao().getUserById(posicion)
        basedatos.userDao().delete(usuarioEliminar)
        adaptador.update(basedatos.userDao().getAll())
        Toast.makeText(applicationContext, "Usuario ${posicion} eliminado", Toast.LENGTH_SHORT).show()
    }

    override fun editUser(id: Int, firstName: String, lastName: String, age: Int) {
        var usuarioEditar = User(id, firstName, lastName, age)
        basedatos.userDao().update(usuarioEditar)
        adaptador.update(basedatos.userDao().getAll())
        Toast.makeText(applicationContext, "Usuario actualizado", Toast.LENGTH_SHORT).show()
    }


}