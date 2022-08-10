package com.brenda.examenretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.brenda.examenretrofit.Dialog.AgregarInmueble
import com.brenda.examenretrofit.R
import com.brenda.examenretrofit.models.Inmuebles
import com.brenda.examenretrofit.providers.DialogListener

class InmuebleAdapter(private var dataSet: ArrayList<Inmuebles>,  val listener: DialogListener) :
    RecyclerView.Adapter<InmuebleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_inmuebles, viewGroup, false)

        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val inmueble:Inmuebles = dataSet[position]
        viewHolder.enlazarItem(inmueble, position)
    }

    override fun getItemCount() = dataSet.size

    fun update(filtro: ArrayList<Inmuebles>) {
        dataSet = filtro
        this.notifyDataSetChanged()
    }

    class ViewHolder(view: View, val listener: DialogListener) : RecyclerView.ViewHolder(view) {
        lateinit var txtName: TextView
        lateinit var txtCategoria: TextView
        lateinit var txtDireccion: TextView
        lateinit var btnEliminar : Button

        val contexto = view.context

        init {
            txtName = view.findViewById(R.id.txtName)
            txtCategoria = view.findViewById(R.id.txtCategoria)
            txtDireccion = view.findViewById(R.id.txtDireccion)
            btnEliminar = view.findViewById(R.id.btnDelete)
        }

        fun enlazarItem(inmuebles: Inmuebles, position: Int){
            txtName.text = inmuebles.nombre.toString()
            txtCategoria.text = inmuebles.categoria.toString()
            txtDireccion.text = inmuebles.direccion.toString()

            btnEliminar.setOnClickListener {
                Toast.makeText(contexto, "Eliminando", Toast.LENGTH_SHORT).show()
                listener.abrirDialogo(position)
                //DeleteDialog(listener)
            }
        }
    }
}