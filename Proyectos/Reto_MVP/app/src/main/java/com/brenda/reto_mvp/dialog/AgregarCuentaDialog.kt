package com.brenda.reto_mvp.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.brenda.reto_mvp.R

class AgregarCuentaDialog(val listener: DialogListener) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            val inflater = requireActivity().layoutInflater;
            val vista = inflater.inflate(R.layout.agregar_cuenta, null)
            //val txtUsername = vista.findViewById<EditText>(R.id.username)

            builder.setView(vista)
                // Add action buttons
                .setPositiveButton("Guardar",
                    DialogInterface.OnClickListener { dialog, id ->
                        //listener.onSignInSuccess(txtUsername.text.toString(), txtPassword.text.toString())
                        listener.añadirCuenta()
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}