package com.brenda.reto_mvp.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.brenda.reto_mvp.R

interface DialogListener{
    fun agregarCuenta()
    fun añadirCuenta()
}