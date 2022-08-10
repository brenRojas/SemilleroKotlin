package com.joseluis.recycleritemselected

class Estatus(var descripcion:String = "",
              var isSelected:Boolean = false) {


    companion object{
        fun obtenerLista():ArrayList<Estatus>{
            var lista = ArrayList<Estatus>()
            lista.add(Estatus("estatus 1",true))
            lista.add(Estatus("estatus 2",false))
            lista.add(Estatus("estatus 3",false))

            return lista
        }
    }
}