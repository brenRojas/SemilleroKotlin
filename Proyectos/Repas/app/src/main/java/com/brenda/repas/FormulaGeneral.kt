package com.brenda.repas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.brenda.repas.databinding.ActivityFormulaGeneralBinding
import kotlin.math.sqrt

class FormulaGeneral : AppCompatActivity() {
    lateinit var binding : ActivityFormulaGeneralBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormulaGeneralBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calcular(view: View) {
        aplicar()
    }

    fun aplicar() {
        var x1: Double = 0.0
        var x2: Double = 0.0

        with(binding){
            var a:Double = numA.text.toString().toDouble()
            var b:Double = numB.text.toString().toDouble()
            var c:Double = numC.text.toString().toDouble()

            if(a == null && b == null && c == null){
                Toast.makeText(applicationContext, "No dejar campos vacios", Toast.LENGTH_SHORT).show()
            }
            if(a == 0.0){
                Toast.makeText(applicationContext, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show()
            }else{
                x1 = ((-1*b) + sqrt(b*b - 4*a*c) ) / (2*a)
                x2 = ((-1*b) - sqrt(b*b - 4*a*c) ) / (2*a)

                resultado1.text = x1.toString()
                resultado2.text = x2.toString()
                Toast.makeText(applicationContext, "$x1, $x2", Toast.LENGTH_SHORT).show()
            }


        }
    }
}
