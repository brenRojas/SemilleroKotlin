package com.brenda.demoretrofil_post.config

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brenda.demoretrofil_post.R
import com.brenda.demoretrofil_post.models.Todos
import com.brenda.demoretrofil_post.models.Users

class UsersAdapter(private val dataSet: ArrayList<Users>) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_users, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtUsersName: TextView
        lateinit var txtUserAddress: TextView
        lateinit var txtUserGeoLat: TextView

        val contexto = view.context

        init {
            txtUsersName = view.findViewById(R.id.txtUsersName)
            txtUserAddress = view.findViewById(R.id.txtUsersAddress)
            txtUserGeoLat = view.findViewById(R.id.txtUsersGeoLat)
        }

        fun enlazarItem(users: Users){
            txtUsersName.text = users.name.toString()
            txtUserAddress.text = users.address.street.toString()
            txtUserGeoLat.text = users.address.geo.lat.toString()
        }

    }

}
