package com.brenda.examenretrofit.Dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.brenda.examenretrofit.R
import com.brenda.examenretrofit.models.Inmuebles
import com.brenda.examenretrofit.providers.DialogListener
import com.brenda.examenretrofit.providers.JsonPlaceHolderProvider

class AgregarInmueble(val listener:DialogListener): DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            val vista = inflater.inflate(R.layout.formulario, null)
            val txtName = vista.findViewById<EditText>(R.id.txtNewName)
            val txtCategoria = vista.findViewById<EditText>(R.id.txtNewCategoria)
            val txtDireccion = vista.findViewById<EditText>(R.id.txtNewDireccion)

            builder.setView(vista)
                .setPositiveButton("Guardar",
                    DialogInterface.OnClickListener { dialog, id ->
                        var inmueble = Inmuebles(txtName.text.toString(), txtCategoria.text.toString(), txtDireccion.text.toString(),"","","")
                        listener.agregar(inmueble)
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}