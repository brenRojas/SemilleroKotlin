package com.brenda.demoretrofil_post.config

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brenda.demoretrofil_post.R
import com.brenda.demoretrofil_post.models.Publicacion
import com.brenda.demoretrofil_post.models.Todos

class TodosAdapter(private val dataSet: ArrayList<Todos>) :
    RecyclerView.Adapter<TodosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_todos, viewGroup, false)

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
        lateinit var txtCompleted: TextView


        val contexto = view.context

        init {
            txtId = view.findViewById(R.id.txtTodosId)
            txtUserId = view.findViewById(R.id.txtTodosUserId)
            txtTitle = view.findViewById(R.id.txtTodosTitle)
            txtCompleted = view.findViewById(R.id.txtTodosCompleted)
        }

        fun enlazarItem(todos: Todos){
            txtId.text     = todos.id.toString()
            txtUserId.text = todos.userId.toString()
            txtTitle.text  = todos.title
            txtCompleted.text   = todos.completed.toString()
        }

    }

}
