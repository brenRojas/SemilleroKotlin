package com.example.demodialogo.dialogos

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.demodialogo.R
import com.example.demodialogo.interfaces.DialogoListener

class CustomDialog(val listener:DialogoListener):DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;
            val vista = inflater.inflate(R.layout.dialog_signin, null)
            val txtUsername = vista.findViewById<EditText>(R.id.username)
            val txtPassword = vista.findViewById<EditText>(R.id.password)

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(vista)
                // Add action buttons
                .setPositiveButton(R.string.singnin,
                    DialogInterface.OnClickListener { dialog, id ->
                        listener.onSignInSuccess(txtUsername.text.toString(), txtPassword.text.toString())
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}