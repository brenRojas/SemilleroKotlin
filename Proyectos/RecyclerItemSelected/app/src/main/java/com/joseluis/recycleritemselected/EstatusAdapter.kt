package com.joseluis.recycleritemselected

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EstatusAdapter( var dataSet: ArrayList<Estatus>) :
    RecyclerView.Adapter<EstatusAdapter.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        lateinit var view:View
        if(viewType == 1){
            view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_list_seleccionado, viewGroup, false)
        }else{
            view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_list_no_seleccionado, viewGroup, false)
        }
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.txtDescripcion.text = dataSet[position].descripcion
        viewHolder.txtDescripcion.setOnClickListener {
            for(estatus in dataSet){
                estatus.isSelected = false
            }
            dataSet[position].isSelected = true
            update(dataSet)
        }
    }


    override fun getItemCount() = dataSet.size

    override fun getItemViewType(position: Int): Int {
        //el 1 representa seleccionado
        return if(dataSet[position].isSelected){
            1
        } else{
            0
        }
    }

    fun update(datos:ArrayList<Estatus>){
        this.dataSet = datos
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtDescripcion: TextView
        init {
            txtDescripcion = view.findViewById(R.id.txtDescripcion)
        }
    }
}
