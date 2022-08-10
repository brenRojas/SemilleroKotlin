package com.brenda.demoroom.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.brenda.demoroom.R
import com.brenda.demoroom.interfaces.DialogListener

class EditUserDialog(val listener: DialogListener, val uid:Int): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;
            val vista = inflater.inflate(R.layout.dialog_edituser, null)

            val editFirstName = vista.findViewById<EditText>(R.id.edit_firstName)
            val editLastName = vista.findViewById<EditText>(R.id.edit_lastName)
            val editEdad = vista.findViewById<EditText>(R.id.edit_age)

            builder.setView(vista)
                // Add action buttons
                .setPositiveButton("Actualizar",
                    DialogInterface.OnClickListener { dialog, id ->
                        listener.editUser(uid, editFirstName.text.toString(), editLastName.text.toString(), editEdad.text.toString().toInt())
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}