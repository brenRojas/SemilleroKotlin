package com.example.demodialogo.dialogos

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.demodialogo.interfaces.DialogoListener
import java.util.*

class TimePickerDialogFragment(val listener:DialogoListener):DialogFragment(), TimePickerDialog.OnTimeSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        var hora = calendar.get(Calendar.HOUR_OF_DAY)
        var minuto = calendar.get(Calendar.MINUTE)
        Calendar.WEEK_OF_YEAR

        return TimePickerDialog(activity as Context, this, hora, minuto, false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute:Int){
        listener.onTimeSelected(isSelected = true, hora = hourOfDay, minuto = minute)
    }

}