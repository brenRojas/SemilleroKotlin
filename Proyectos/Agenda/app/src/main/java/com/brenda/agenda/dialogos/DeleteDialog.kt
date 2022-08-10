package com.brenda.agenda.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.brenda.agenda.R
import com.brenda.agenda.interfaces.DialogoListener

class DeleteDialog (val listener: DialogoListener, val posicionBorrar:Int) : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.dialog_eliminar)
                .setPositiveButton(R.string.delete_true,
                    DialogInterface.OnClickListener { dialog, id ->
                        //To do, ejecutar en caso positivo
                        //listener.onMissileFired("A disparar!!")
                        listener.borrarItem(posicionBorrar)
                    })
                .setNegativeButton(R.string.delete_false,
                    DialogInterface.OnClickListener { dialog, id ->
                        //To do, ejecutar en caso negativo
                       // listener.onMissileFired("No :(")

                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}