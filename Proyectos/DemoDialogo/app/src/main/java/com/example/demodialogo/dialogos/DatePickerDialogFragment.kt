package com.example.demodialogo.dialogos

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.demodialogo.interfaces.DialogoListener
import java.util.*

class DatePickerDialogFragment(val listener:DialogoListener):DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity as Context,this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year:Int, month:Int, dayOfMonth:Int ) {
        listener.onDateSelected(year, month, dayOfMonth)
    }
}