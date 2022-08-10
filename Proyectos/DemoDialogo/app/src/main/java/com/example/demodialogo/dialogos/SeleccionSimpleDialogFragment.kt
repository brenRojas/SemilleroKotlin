package com.example.demodialogo.dialogos

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.demodialogo.R
import com.example.demodialogo.interfaces.DialogoListener

class SeleccionSimpleDialogFragment(val listener: DialogoListener):DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val arrayTopings = arrayOf<String>("Buffalo","BBQ","Mayonesa","Caesar","Chipotle")
        return activity?.let {

            val selectedItems = ArrayList<Int>()
            val selectedToppings = ArrayList<String>()
            val builder = AlertDialog.Builder(it)
            var seleccionado = arrayTopings[0]

            builder.setTitle(R.string.pick_toppings)
                .setSingleChoiceItems(arrayTopings, 0,
                    DialogInterface.OnClickListener { dialog, which ->
                        seleccionado = arrayTopings[which]
                    })

                // Set the action buttons
                .setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User clicked OK, so save the selectedItems results somewhere
                        // or return them to the component that opened the dialog
                        listener.onSingleSelected(seleccionado)
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        //listener.onListSelected(selectedToppings)
                    })

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}