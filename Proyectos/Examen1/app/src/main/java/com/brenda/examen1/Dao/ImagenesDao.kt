package com.brenda.examen1.Dao

import com.brenda.examen1.R
import com.brenda.examen1.model.Imagenes

class ImagenesDao {
    companion object{
        var IMAGENES_ID = "IMAGENES_ID"
    }

    fun getListImagenes(): ArrayList<Imagenes>{
        val listImagenes = ArrayList<Imagenes>()

        listImagenes.add(Imagenes(R.drawable.ise_item_flor))
        listImagenes.add(Imagenes(R.drawable.ise_item_flor))
        listImagenes.add(Imagenes(R.drawable.ise_item_flor))
        listImagenes.add(Imagenes(R.drawable.ise_item_flor))
        listImagenes.add(Imagenes(R.drawable.ise_item_flor))
        listImagenes.add(Imagenes(R.drawable.ise_item_flor))
        listImagenes.add(Imagenes(R.drawable.ise_item_flor))
        listImagenes.add(Imagenes(R.drawable.ise_item_flor))


        return listImagenes
    }




}