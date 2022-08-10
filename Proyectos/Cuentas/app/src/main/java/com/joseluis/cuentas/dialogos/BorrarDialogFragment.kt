package com.joseluis.cuentas.dialogos

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class BorrarDialogFragment(val posicion:Int,val objeto:DialogoListener) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Deseas borrar esta cuenta?")
                .setPositiveButton("Sí, wapo",
                    DialogInterface.OnClickListener { dialog, id ->
                        objeto.borrar(posicion)
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    interface DialogoListener{
        fun borrar(posicion:Int)
    }
}