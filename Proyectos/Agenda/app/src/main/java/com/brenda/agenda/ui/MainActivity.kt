package com.brenda.agenda.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.brenda.agenda.R
import com.brenda.agenda.adapter.ContactosAdapter
import com.brenda.agenda.dao.ContactosDao
import com.brenda.agenda.databinding.ActivityMainBinding
import com.brenda.agenda.dialogos.DeleteDialog
import com.brenda.agenda.interfaces.DialogoListener
import com.brenda.agenda.models.Contacto

class MainActivity : AppCompatActivity(), DialogoListener {
    lateinit var binding:ActivityMainBinding
    lateinit var contactos: ArrayList<Contacto>
    var daoContactos: ContactosDao = ContactosDao()
    lateinit var adaptador : ContactosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactos = daoContactos.getContactosList()

        adaptador = ContactosAdapter(contactos, this)
        binding.agendaRecycler.adapter = adaptador

        binding.agendaRecycler.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    fun abrirDialogo(view: View) {
        when(view.id){
            R.id.btnEliminar -> {
                onDeleteContact("")
                Toast.makeText(applicationContext, "Delete..", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onDeleteContact(s: String) {
        Toast.makeText(applicationContext, "Delete..", Toast.LENGTH_SHORT).show()
    }

    override fun onCallContact(s: String) {
        Toast.makeText(applicationContext, "Llamando..", Toast.LENGTH_SHORT).show()
    }

    override fun abrirDialogo(posicion: Int) {
        val newFragment = DeleteDialog(this, posicion)
        newFragment.show(supportFragmentManager, "missiles")    }

    override fun borrarItem(posicion: Int) {
        contactos.removeAt(posicion)
        adaptador.update(contactos)
    }
}