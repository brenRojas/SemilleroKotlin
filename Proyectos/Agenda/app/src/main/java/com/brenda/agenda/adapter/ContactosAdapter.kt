package com.brenda.agenda.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.brenda.agenda.R
import com.brenda.agenda.interfaces.DialogoListener
import com.brenda.agenda.models.Contacto
import androidx.core.content.ContextCompat.startActivity
import com.brenda.agenda.dialogos.DeleteDialog


class ContactosAdapter(private var dataSet: ArrayList<Contacto>, val listener: DialogoListener) :
    RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_contacto, viewGroup, false)

        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val contacto:Contacto = dataSet[position]
        viewHolder.enlazarItem(contacto, position)
    }

    override fun getItemCount() = dataSet.size

    fun update(filtro: ArrayList<Contacto>) {
        dataSet = filtro
        this.notifyDataSetChanged()
    }

    class ViewHolder(view: View, val listener: DialogoListener) : RecyclerView.ViewHolder(view) {
        lateinit var txtNombre: TextView
        lateinit var txtTelefono: TextView
        lateinit var imgContacto: ImageView
        lateinit var btnLlamar: Button
        lateinit var btnEliminar: Button
        val contexto = view.context

        init {
            txtNombre = view.findViewById(R.id.txtNombre)
            txtTelefono = view.findViewById(R.id.txtTelefono)
            imgContacto = view.findViewById(R.id.imgContacto)
            btnLlamar = view.findViewById(R.id.btnLlamar)
            btnEliminar = view.findViewById(R.id.btnEliminar)
        }

        fun enlazarItem(contacto: Contacto, position: Int) {
            txtNombre.text = contacto.name
            txtTelefono.text = contacto.telephone
            imgContacto.setImageResource(contacto.imageId)

            btnLlamar.setOnClickListener {
                Toast.makeText(contexto, "Llamando", Toast.LENGTH_SHORT).show()
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", txtTelefono.toString(), null))
                //startActivity(intent)

            }

            btnEliminar.setOnClickListener {
                Toast.makeText(contexto, "Eliminando", Toast.LENGTH_SHORT).show()
                listener.abrirDialogo(position)
                //DeleteDialog(listener)
            }

        }
    }
}

