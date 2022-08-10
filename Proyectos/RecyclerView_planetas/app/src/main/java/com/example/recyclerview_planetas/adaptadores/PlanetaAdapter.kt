package com.example.recyclerview_planetas.adaptadores

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_planetas.R
import com.example.recyclerview_planetas.dao.PlanetasDao
import com.example.recyclerview_planetas.models.Planeta
import com.example.recyclerview_planetas.ui.DetallePlanetaActivity


class PlanetaAdapter(private val dataSet: ArrayList<Planeta>) :
    RecyclerView.Adapter<PlanetaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_planet_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val planeta:Planeta = dataSet[position]
        viewHolder.enlazarItem(planeta)
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtPlaneta: TextView
        lateinit var imgPlaneta: ImageView
        lateinit var btn_VerDetallePlaneta: Button
        val contexto = view.context

        init {
            txtPlaneta = view.findViewById(R.id.txtPlaneta)
            imgPlaneta = view.findViewById(R.id.imgPlaneta)
            btn_VerDetallePlaneta = view.findViewById(R.id.btn_VerDetallePlaneta)
        }


        fun enlazarItem(planeta: Planeta){
            txtPlaneta.text = planeta.name
            imgPlaneta.setImageResource(planeta.imageId)
            btn_VerDetallePlaneta.setOnClickListener {
                val intent = Intent(contexto, DetallePlanetaActivity::class.java)
                intent.putExtra(PlanetasDao.PLANETA_NAME, planeta.name)
                intent.putExtra(PlanetasDao.PLANETA_DESCRIPCION, planeta.description)
                intent.putExtra(PlanetasDao.PLANETA_IMAGE, planeta.imageId)
                contexto.startActivity(intent)
            }
        }

    }

}

