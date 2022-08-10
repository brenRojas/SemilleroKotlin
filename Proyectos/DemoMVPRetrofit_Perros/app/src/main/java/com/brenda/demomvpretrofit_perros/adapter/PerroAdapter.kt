package com.brenda.demomvpretrofit_perros.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brenda.demomvpretrofit_perros.R
import com.bumptech.glide.Glide


class PerroAdapter(private var dataSet: ArrayList<String>) :
    RecyclerView.Adapter<PerroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.perro_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imgPerro: ImageView

        init {
            imgPerro = view.findViewById(R.id.imgPerro)
        }

        fun enlazarItem(item:String){
            Glide.with(view.context).load(item).into(imgPerro);
        }
    }

}

