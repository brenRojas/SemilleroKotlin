package com.brenda.reto_mvp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.brenda.reto_mvp.MainActivity
import com.brenda.reto_mvp.R
import com.brenda.reto_mvp.datos.Cuenta
import com.brenda.reto_mvp.dialog.DialogListener
import com.brenda.reto_mvp.views.CuentaFragment
import com.brenda.reto_mvp.views.CuentasViewsListener
import com.brenda.reto_mvp.views.UserFragment


class UserAdapter(private var dataSet: ArrayList<Cuenta>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun update(filtro: ArrayList<Cuenta>) {
        dataSet = filtro
        this.notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textName: TextView
        val textCuenta : TextView
        val card : CardView
        val contexto = view.context


        init {
            textName = view.findViewById(R.id.nameUser)
            textCuenta = view.findViewById(R.id.cuentaUser)
            card = view.findViewById(R.id.cardUser)
        }

        fun enlazarItem(cuenta: Cuenta) {
            textName.text = cuenta.nombre
            textCuenta.text = cuenta.numCuenta



            card.setOnClickListener{
                it.findNavController().navigate(R.id.cuentaFragment)

            }
        }
    }


}

