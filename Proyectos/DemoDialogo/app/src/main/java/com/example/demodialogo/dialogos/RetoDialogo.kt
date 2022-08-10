package com.example.demodialogo.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.demodialogo.R
import com.example.demodialogo.databinding.ActivityRetoDialogoBinding
import com.example.demodialogo.interfaces.DialogoListener

class RetoDialogo : AppCompatActivity(), DialogoListener {

    lateinit var binding: ActivityRetoDialogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetoDialogoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun abrirDialogo(view: View) {
        when (view.id) {
            R.id.et_Fecha -> {
                val newFragment = DatePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "fecha")
            }
            R.id.et_Hora -> {77
                val newFragment = TimePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "hora")
            }
        }
    }



    override fun onDateSelected(year: Int, month: Int, day: Int) {
        //Toast.makeText(applicationContext, "La fecha es: $day/${month+1}/$year", Toast.LENGTH_SHORT).show()
        binding.etFecha.setText("Fecha ingresada: $day/${month+1}/$year")
    }

    override fun onTimeSelected(isSelected: Boolean, hora: Int, minuto: Int) {
        if(isSelected){
            if(minuto<10){
                //Toast.makeText(applicationContext, "$hora:0$minuto", Toast.LENGTH_SHORT).show()
                binding.etHora.setText("Hora ingresada: $hora:0$minuto")
            }else{
                //Toast.makeText(applicationContext, "$hora:$minuto", Toast.LENGTH_SHORT).show()
                binding.etHora.setText("Hora ingresada: $hora:$minuto")
            }
        }else{
            //Toast.makeText(applicationContext, "No se seleccion hora", Toast.LENGTH_SHORT).show()
            binding.etHora.setText("No selecciono hora")
        }
    }


    override fun onMissileFired(respuesta: String) {
        TODO("Not yet implemented")
    }
    override fun onListSelected(lista: ArrayList<String>) {
        TODO("Not yet implemented")
    }
    override fun onSingleSelected(topping: String) {
        TODO("Not yet implemented")
    }

    override fun onSignInSuccess(username: String, password: String) {
        TODO("Not yet implemented")
    }

}