package com.brenda.agenda.dao

import com.brenda.agenda.R
import com.brenda.agenda.models.Contacto

class ContactosDao {
    companion object{
        var USER_ID = "USER_ID"
        var USER_NAME = "USER_NAME"
        var USER_IMAGE = "USER_IMAGE"
        var USER_TELEPHONE = "USER_TELEPHONE"
    }

    fun getContactosList(): ArrayList<Contacto> {
        val listaAgenda = ArrayList<Contacto>()
        listaAgenda.add(Contacto(1,"Brenda Rojas", "2215978529", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(2,"Claudia Pérez", "2221113456", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(3,"Héctor Rojas", "2290865432", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(4,"Mercedes", "2278909760", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(5,"Jorge Pérez", "2233334456", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(6,"Itzel de la Luz", "209876436", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(7,"Miguel Rodriguez", "2255555529", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(8,"Fernanda Rodriguez", "2209876543", R.drawable.ise_person_100))
        listaAgenda.add(Contacto(9,"Bryan Rojas", "555678075", R.drawable.ise_person_100))

        return listaAgenda
    }
}