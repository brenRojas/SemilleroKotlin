package com.joseluis.cuentas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.joseluis.cuentas.R
import com.joseluis.cuentas.database.Database
import com.joseluis.cuentas.models.ClenteCuentas
import com.joseluis.cuentas.ui.fragments.ListaFragmentDirections


class CuentaAdapter(private var dataSet: ArrayList<ClenteCuentas>) :
    RecyclerView.Adapter<CuentaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cuenta_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(dataSet[position],position)
    }

    override fun getItemCount() = dataSet.size

    fun update(nuevaLista: ArrayList<ClenteCuentas>){
        this.dataSet = nuevaLista
        notifyDataSetChanged()
    }
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val txtItemCliente: TextView
        val txtItemCuenta: TextView
        val txtItemSaldo: TextView
        val contexto = view.context

        init {
            // Define click listener for the ViewHolder's View.
            txtItemCliente = view.findViewById(R.id.txtItemCliente)
            txtItemCuenta = view.findViewById(R.id.txtItemCuenta)
            txtItemSaldo = view.findViewById(R.id.txtItemSaldo)
        }

        fun enlazarItem(item:ClenteCuentas,posicion:Int){
            txtItemCliente.text = item.mCliente.nombre
            txtItemCuenta.text  = "Cuenta: "+item.mCuenta.numero.toString()
            txtItemSaldo.text   = "Saldo: $"+item.mCuenta.saldo.toString()

            val action = ListaFragmentDirections.actionListaFragmentToDetailFragment(
                posicion = posicion,
                cuentaCliente = item,
                operacion = Database.OPERACION_EDITAR
            )

            view.setOnClickListener {
                this.view.findNavController().navigate(action)
            }
        }
    }
}
