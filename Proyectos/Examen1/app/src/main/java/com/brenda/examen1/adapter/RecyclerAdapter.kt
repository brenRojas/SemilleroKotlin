package com.brenda.examen1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.brenda.examen1.R
import com.brenda.examen1.config.ConfiguracionInicial.Companion.preferenciasGlobal
import com.brenda.examen1.model.Imagenes


class RecyclerAdapter(private val dataSet: ArrayList<Imagenes>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recycler, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val img:Imagenes = dataSet[position]
        viewHolder.enlazarItem(img)
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        lateinit var imgRecycler: ImageView
        init {
            imgRecycler = view.findViewById(R.id.imgRecycler)
        }


        fun enlazarItem(img: Imagenes){
            imgRecycler.setImageResource(img.imageId)
            imgRecycler.setOnClickListener{
                val nombre =  preferenciasGlobal.recuperarNombre()
                val correo =  preferenciasGlobal.recuperarCorreo()
                Toast.makeText(view.context,"$nombre, $correo", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

