package com.example.repaso.basededatos

import com.example.repaso.interfaces.BaseDatosListener

class PersonasDao(val listener: BaseDatosListener) {
    fun seleccionaPersonasGuapas(){
        var lista = ArrayList<String>()
        lista.add("Claudia")
        lista.add("Mercedes")
        lista.add("Bryan")
        lista.add("Miguel")
        lista.add("Jorge")
        lista.add("Fernanda")

        //Listener refresca la interfaz que lo implementa
        listener.selectAll(lista)
        listener.deleteAll(lista)
    }


}