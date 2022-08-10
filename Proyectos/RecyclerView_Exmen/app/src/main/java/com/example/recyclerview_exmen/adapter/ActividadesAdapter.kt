package com.example.recyclerview_exmen.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_exmen.R
import com.example.recyclerview_exmen.models.Actividad
import com.example.recyclerview_exmen.ui.DetalleActividad
import com.example.recyclerview_exmen.ui.MainActivity2
import com.example.recyclerview_planetas.dao.ActividadesDao


class ActividadesAdapter(private val dataSet: ArrayList<Actividad>) :
    RecyclerView.Adapter<ActividadesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_actividad, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val actividad: Actividad = dataSet[position]
        viewHolder.enlazarItem(actividad)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtActividad: TextView
        val contexto = view.context

        init {
            txtActividad = view.findViewById(R.id.txtActividad)
        }

        fun enlazarItem(actvidad: Actividad){


            txtActividad.text = actvidad.name

            txtActividad.setOnClickListener {
                Toast.makeText(contexto, "successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(contexto, DetalleActividad::class.java)
                intent.putExtra(ActividadesDao.ACTIVIDAD_CATEGORIA, actvidad.categoria)
                intent.putExtra(ActividadesDao.ACTIVIDAD_NAME, actvidad.name)
                intent.putExtra(ActividadesDao.ACTIVIDAD_DESCRIPCION, actvidad.description)
                intent.putExtra(ActividadesDao.ACTIVIDAD_IMAGE, actvidad.imageId)
                contexto.startActivity(intent)
            }
        }
    }

}

