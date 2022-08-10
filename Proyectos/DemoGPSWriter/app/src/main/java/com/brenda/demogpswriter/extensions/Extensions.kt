package com.brenda.demogpswriter.extensions

import android.app.Activity
import android.widget.Toast


fun Activity.toast(mensaje:String, duracion:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, mensaje, duracion).show()
}