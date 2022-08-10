package com.example.demorecyclerview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerview2.databinding.TextRowItemBinding


class EstadosAdapter(var dataSet: List<String>) :
    RecyclerView.Adapter<EstadosAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var id_vista = if(viewType == 0){
            R.layout.text_row_item_purple
        }else{
            R.layout.text_row_item
        }
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(id_vista, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    //Enlaza a traves de la clase Viewholder cada elemento de la lista con cada elemento del Xml
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        //viewHolder.txtEstado.text = dataSet[position]
        viewHolder.enlazarItem(dataSet[position])
    }

    //Devuelve el tamaño de la lista de datos (dataset)
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    //Un elemento color rojo y uno negro
    override fun getItemViewType(position: Int): Int {
        return (position%2)
    }

    fun update(filtro: List<String>) {
        dataSet = filtro
        this.notifyDataSetChanged()
    }

    //Se define que mostrará cada elemento del XML y su comportamiento
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = TextRowItemBinding.bind(view)
        var contexto = view.context


        //init {
            // Define click listener for the ViewHolder's View.
            //txtEstado = view.findViewById(R.id.txt_estado)
        //}

        fun enlazarItem(estado: String){
            binding.txtEstado.text = estado

            binding.txtEstado.setOnClickListener {
                Toast.makeText(contexto, "Seleccionaste $estado", Toast.LENGTH_LONG).show()
            }
        }

    }
}
