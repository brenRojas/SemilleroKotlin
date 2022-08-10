package com.example.demowidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast

class Actividad2 : AppCompatActivity() {

    lateinit var grupoUno:RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)
        grupoUno = findViewById(R.id.RGUno)
        //mostrarLog("Create A2")
    }

    //Ciclo de vida de una actividad
    /*override fun onStart(){
        super.onStart()
        mostrarLog("OnStart A2")
    }

    override fun onResume(){
        super.onResume()
        mostrarLog("OnResume A2")
    }

    override fun onRestart(){
        super.onRestart()
        mostrarLog("OnRestart A2")
    }

    override fun onPause(){
        super.onPause()
        mostrarLog("OnPause A2")
    }

    override fun onStop(){
        super.onStop()
        mostrarLog("OnStop A2")
    }

    //Aveces no se muestran los Logs, es posible verlo o no
    override fun onDestroy(){
        super.onDestroy()
        mostrarLog("OnDestroy A2")
    }

    private fun mostrarLog(s: String) {
        Log.d("Mensaje", s)
    }*/

    fun verificarCheck(view: android.view.View) {

        //Verificar estas condiciones para que funciones los widgets
        /*val check = view as CheckBox //Otro tipo de declaración de tipo casting
        val switch = view as Switch
        if(check.isChecked || switch.isChecked){
            Toast.makeText(applicationContext, "Checked True", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Checked False", Toast.LENGTH_SHORT).show()
        }*/

        ////////////////////////////////////////////////////////////////////////////////////////////////
        //Mediante un botón conocer el estado del CheckBox y el Switch
        /*val check:CheckBox = findViewById(R.id.chkBoxUno)
        val switch:Switch = findViewById(R.id.SwitchUno)

        Toast.makeText(applicationContext, "check = ${check.isChecked}. switch = ${switch.isChecked}", Toast.LENGTH_SHORT).show()*/

        ////////////////////////////////////////////////////////////////////////////////////////////////

        //Utilizar Radio Group y Radio Buttons y verificar sus estados

        val radioSelected:Int = grupoUno.checkedRadioButtonId
        val check:CheckBox = findViewById(R.id.chkBoxUno)
        val switch:Switch = findViewById(R.id.SwitchUno)

        var opcion = when(radioSelected){
            R.id.RBUno -> {"Radio 1"}
            R.id.RBDos -> {"Radio 2"}
            else ->"Radio 3"
        }

        val mensaje = "check = ${check.isChecked}. switch = ${switch.isChecked}. radio = $opcion"
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()

        ////////////////////////////////////////////////////////////////////////////////////////////////

    }

}