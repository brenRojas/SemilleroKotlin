package com.brenda.examenretrofit.Dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.brenda.examenretrofit.R
import com.brenda.examenretrofit.providers.DialogListener
import com.brenda.examenretrofit.providers.JsonPlaceHolderProvider

class DeleteDialog (val listener: DialogListener, val posicionBorrar:Int) : DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("¿Desea eliminar el inmueble?")
                .setPositiveButton("Si",
                    DialogInterface.OnClickListener { dialog, id ->
                        listener.borrarItem(posicionBorrar)
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}