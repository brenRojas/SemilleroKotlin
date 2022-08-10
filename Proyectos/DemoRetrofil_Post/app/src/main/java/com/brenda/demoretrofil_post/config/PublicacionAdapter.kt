package com.brenda.demoretrofil_post.config

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brenda.demoretrofil_post.R
import com.brenda.demoretrofil_post.models.Publicacion

class PublicacionAdapter(private val dataSet: ArrayList<Publicacion>) :
    RecyclerView.Adapter<PublicacionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recycler, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtUserId: TextView
        lateinit var txtId: TextView
        lateinit var txtTitle: TextView
        lateinit var txtBody: TextView


        val contexto = view.context

        init {
            txtId = view.findViewById(R.id.txtId)
            txtUserId = view.findViewById(R.id.txtUserId)
            txtBody = view.findViewById(R.id.txtBody)
            txtTitle = view.findViewById(R.id.txtTitle)

        }

        fun enlazarItem(publicacion: Publicacion){
            txtId.text     = publicacion.id.toString()
            txtUserId.text = publicacion.userId.toString()
            txtTitle.text  = publicacion.title
            txtBody.text   = publicacion.body

        }

    }

}

