package com.brenda.demotesting

import com.brenda.demotesting.models.Persona

class Edad {
    fun mayorEdad(personas:ArrayList<Persona>) : Boolean{
        var mayor = true
        for(persona in personas){
            if(persona.edad < 18){
                mayor == false
                break
            }else{
                mayor == true
            }
        }
        return mayor
    }
}