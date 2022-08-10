package com.example.demodialogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.demodialogo.dialogos.*
import com.example.demodialogo.interfaces.DialogoListener

class MainActivity : AppCompatActivity(), DialogoListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abrirDialogo(view: View) {
        when(view.id){
            R.id.btnDisparar -> {
                val newFragment = FireMissilesDialogFragment(this)
                newFragment.show(supportFragmentManager, "missiles")
            }
            R.id.btnHora -> {
                val newFragment = TimePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "time")
            }
            R.id.btnMultiple -> {
                val newFragment = ListaDialogFragment(this)
                newFragment.show(supportFragmentManager, "lista")
            }
            R.id.btnDate -> {
                val newFragment = DatePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "date")
            }
            R.id.btnSimple -> {
                val newFragment = SeleccionSimpleDialogFragment(this)
                newFragment.show(supportFragmentManager, "simple")
            }
            R.id.btnCustom -> {
                val newFragment = CustomDialog(this)
                newFragment.show(supportFragmentManager, "custom")
            }
        }

    }

    override fun onMissileFired(respuesta: String) {
        Toast.makeText(applicationContext, respuesta, Toast.LENGTH_SHORT).show()
    }

    override fun onTimeSelected(isSelected: Boolean, hora: Int, minuto: Int) {
        if(isSelected){
            if(minuto<10){
                Toast.makeText(applicationContext, "$hora:0$minuto", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "$hora:$minuto", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(applicationContext, "No se seleccion hora", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onListSelected(lista: ArrayList<String>) {
        var mensaje = ""
        lista.forEach{
            mensaje += "Topping = $it \n"
        }
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun onDateSelected(year: Int, month: Int, day: Int) {
        Toast.makeText(applicationContext, "La fecha es: $day/${month+1}/$year", Toast.LENGTH_SHORT).show()
    }

    override fun onSingleSelected(topping: String) {
        Toast.makeText(applicationContext, "La selección es: $topping", Toast.LENGTH_SHORT).show()
    }

    override fun onSignInSuccess(username: String, password: String) {
        Toast.makeText(applicationContext, "Usuario: $username, Password: $password", Toast.LENGTH_SHORT).show()
    }
}