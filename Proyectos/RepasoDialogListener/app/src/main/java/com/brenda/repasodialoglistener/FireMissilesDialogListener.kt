package com.brenda.repasodialoglistener

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class FireMissilesDialogListener(val objeto:DialogoListener) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Disparar función del listener")
                .setPositiveButton("Si",
                    DialogInterface.OnClickListener { dialog, id ->
                        objeto.siDisparar("Por Infiel")
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        objeto.noDisparar("Por Santo")
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}