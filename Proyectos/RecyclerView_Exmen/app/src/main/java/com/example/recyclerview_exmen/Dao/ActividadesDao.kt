package com.example.recyclerview_planetas.dao

import com.example.recyclerview_exmen.R
import com.example.recyclerview_exmen.models.Actividad


class ActividadesDao {
    companion object{
        var ACTIVIDAD_CATEGORIA = "ACTIVIDAD_CATEGORIA"
        var ACTIVIDAD_NAME = "ACTIVIDAD_NAME"
        var ACTIVIDAD_IMAGE = "ACTIVIDAD_IMAGE"
        var ACTIVIDAD_DESCRIPCION = "ACTIVIDAD_DESCRIPCION"
    }

    fun getListActividades(): ArrayList<Actividad> {
        val listActividades = ArrayList<Actividad>()
        listActividades.add(Actividad("Animales","Pantera","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_animales_150 ))
        listActividades.add(Actividad("Animales","Tigre","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_animales_150 ))
        listActividades.add(Actividad("Animales","Lobo","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_animales_150 ))
        listActividades.add(Actividad("Animales","Gato","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_animales_150 ))
        listActividades.add(Actividad("Animales","Perro","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_animales_150 ))

        listActividades.add(Actividad("Deportes","Futbol","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_deportes_150 ))
        listActividades.add(Actividad("Deportes","Basquetball","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_deportes_150 ))
        listActividades.add(Actividad("Deportes","Natación","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_deportes_150 ))
        listActividades.add(Actividad("Deportes","Tennis","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_deportes_150 ))

        listActividades.add(Actividad("Comida","Enchiladas","Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.", R.drawable.ise_deportes_150 ))

        return listActividades
    }




}