package com.brenda.demoroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brenda.demoroom.R
import com.brenda.demoroom.interfaces.DialogListener
import com.brenda.demoroom.models.User


class UserAdapter(private var dataSet: List<User>, val listener:DialogListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_item, viewGroup, false)

        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, posicion: Int) {

        val user:User = dataSet[posicion]
        viewHolder.enlazarItem(user, posicion)
    }

    override fun getItemCount() = dataSet.size

    fun update(filtro: List<User>) {
        dataSet = filtro
        this.notifyDataSetChanged()
    }

    class ViewHolder(view: View, val listener: DialogListener) : RecyclerView.ViewHolder(view) {
        val txtId : TextView
        val txtNombre : TextView
        val txtApellido : TextView
        val txtEdad : TextView
        val btnEliminar : Button
        val btnEditar : Button

        init {
            txtId = view.findViewById(R.id.txtId)
            txtNombre = view.findViewById(R.id.txtNombre)
            txtApellido = view.findViewById(R.id.txtApellido)
            txtEdad = view.findViewById(R.id.txtEdad)
            btnEliminar = view.findViewById(R.id.btnEliminar)
            btnEditar = view.findViewById(R.id.btnEditar)
        }

        fun enlazarItem(item : User, uid: Int){
            txtId.text = "Id: ${item.uid}"
            txtNombre.text = "${item.firstName}"
            txtApellido.text = " ${item.lastName}"
            txtEdad.text = "${item.age} años"

            btnEliminar.setOnClickListener {
                listener.eliminarDialogo(item.uid)
            }

            btnEditar.setOnClickListener {
                listener.editarDialogo(item.uid)
            }
        }
    }
}

