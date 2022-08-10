package com.brenda.demoroom.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.brenda.demoroom.R
import com.brenda.demoroom.interfaces.DialogListener

class AddUserDialog(val listener:DialogListener):DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;
            val vista = inflater.inflate(R.layout.dialog_adduser, null)

            val txtFirstName = vista.findViewById<EditText>(R.id.et_firstName)
            val txtLastName = vista.findViewById<EditText>(R.id.et_lastName)
            val txtEdad = vista.findViewById<EditText>(R.id.et_age)

            builder.setView(vista)
                // Add action buttons
                .setPositiveButton("Agregar",
                    DialogInterface.OnClickListener { dialog, id ->
                        listener.addUser(txtFirstName.text.toString(), txtLastName.text.toString(), txtEdad.text.toString().toInt())
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}