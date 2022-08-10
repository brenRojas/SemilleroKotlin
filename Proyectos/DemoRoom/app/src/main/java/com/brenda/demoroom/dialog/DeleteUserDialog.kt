package com.brenda.demoroom.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.brenda.demoroom.R
import com.brenda.demoroom.interfaces.DialogListener

class DeleteUserDialog(val listener: DialogListener, val uid:Int): DialogFragment()  {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("¿Desea eliminar?")
                .setPositiveButton("Eliminar",
                    DialogInterface.OnClickListener { dialog, id ->
                        //To do, ejecutar en caso positivo
                        //listener.onMissileFired("A disparar!!")
                        listener.deleteUser(uid)
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        //To do, ejecutar en caso negativo
                        //listener.onMissileFired("No :(")
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}