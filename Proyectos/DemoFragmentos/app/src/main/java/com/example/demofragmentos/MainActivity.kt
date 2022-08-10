package com.example.demofragmentos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demofragmentos.dialogos.FireMissilesDialogFragment
import com.example.demofragmentos.ui.PurpleFragment
import com.example.demofragmentos.ui.RojoFragment
import com.example.demofragmentos.ui.YellowFragment

class MainActivity : AppCompatActivity(), FireMissilesDialogFragment.MisilesListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        val fragmentRojo = RojoFragment()
        val fragmentAmarillo = YellowFragment()

        transaction.replace(R.id.contenedor, fragmentRojo)
        transaction.commit()

        if(RojoFragment().isVisible){
            transaction.replace(R.id.contenedor, fragmentRojo)
        }else if(PurpleFragment().isVisible){
            transaction.replace(R.id.contenedor, fragmentAmarillo)
        }
    }

    fun cambiarFragment(view: View){
        val newFragment = when(view.id){
            R.id.btnFragmentUno -> {
                RojoFragment()
            }
            R.id.btnFragmentDos -> {
                PurpleFragment()
            }else -> {
                YellowFragment()
            }
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedor, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun saludar(mensaje:String){
        Toast.makeText(applicationContext, "Saludo en el MainActivity $mensaje", Toast.LENGTH_SHORT).show()
    }

    fun llamarEventoFragment(view: android.view.View) {
        val dialog = FireMissilesDialogFragment(this)
        dialog.show(supportFragmentManager, "NoticeDialogFragment")
    }

    override fun disparar() {
        Toast.makeText(applicationContext, "Disparar", Toast.LENGTH_SHORT).show()
    }

    override fun piedad() {
        Toast.makeText(applicationContext, "No disparar", Toast.LENGTH_SHORT).show()
    }
}