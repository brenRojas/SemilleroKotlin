package com.example.recyclerview_planetas.dao

import com.example.recyclerview_planetas.R
import com.example.recyclerview_planetas.models.Planeta

class PlanetasDao {
    companion object{
        var PLANETA_NAME = "PLANETA_NAME"
        var PLANETA_IMAGE = "PLANETA_IMAGE"
        var PLANETA_DESCRIPCION = "PLANETA_DESCRIPCION"
    }

    fun getPlanetList(): ArrayList<Planeta> {
        var listaPlanetas = ArrayList<Planeta>()
        listaPlanetas.add(Planeta("Mercurio","Es el primer planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Venus","Es el segundo planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Tierra","Es el tercer planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Marte","Es el cuart planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Júpiter","Es el quinto planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Saturno","Es el sexto planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Urano","Es el septimo planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Neptuno","Es el octavo planeta", R.drawable.ise_sol_120))
        listaPlanetas.add(Planeta("Plutón","Es el neptuno planeta", R.drawable.ise_sol_120))

        return listaPlanetas
    }
}