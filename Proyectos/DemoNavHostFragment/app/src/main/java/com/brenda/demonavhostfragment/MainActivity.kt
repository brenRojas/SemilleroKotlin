package com.brenda.demonavhostfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    lateinit var navHostFragment: NavHostFragment
    lateinit var navController : NavController
    var idFragmentoVisible = R.id.unoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            idFragmentoVisible = destination.id
        }
    }

    fun cambiarFragmento(view: android.view.View) {
        val idFragmento = when(view.id){
            R.id.btn1 -> {
                R.id.unoFragment
            }
            R.id.btn2 -> {
                R.id.dosFragment
            }
            else -> {
                R.id.tresFragment
            }
        }

        if(idFragmento != idFragmentoVisible){
            navController.navigate(idFragmento)
        }
        idFragmentoVisible = idFragmento

    }
}