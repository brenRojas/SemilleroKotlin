package com.brenda.demoux.models

class TiposCuenta(val idTipo:Int,val descripcion:String) {
    companion object{
        fun obtenerTiposCuenta(): ArrayList<TiposCuenta> {

            return arrayListOf<TiposCuenta>(
                TiposCuenta(1,"Débito"),
                TiposCuenta(2,"Crédito"),
                TiposCuenta(3,"Cheques")
            )
        }
    }

    override fun toString():String{
        return  "$idTipo - $descripcion"
    }
}

