package com.brenda.repasodialoglistener

class CustomAdapter(val dataset:ArrayList<String>, val objeto:DialogoListener){

    fun onBindViewHolder() : viewHolder{
        return viewHolder(objeto)
    }

    class viewHolder(val objeto: DialogoListener){
        fun enlazarItem(item:String){
            objeto.abrirDialogo()
        }
    }
}

class Main(){
    var lista = ArrayList<String>()
    var mAnimal = CustomAdapter(lista, this )
}