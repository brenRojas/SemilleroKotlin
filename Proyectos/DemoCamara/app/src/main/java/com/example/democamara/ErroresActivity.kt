package com.example.democamara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.democamara.databinding.ActivityErroresBinding
import java.lang.Exception

class ErroresActivity : AppCompatActivity() {

    lateinit var binding: ActivityErroresBinding
    var n1:Double = 0.0
    var n2:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityErroresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnSuma.setOnClickListener {
                recuperarValores()
                val rSuma = calculadora(n1, n2, ::suma)
                Toast.makeText(applicationContext, "Suma = $rSuma", Toast.LENGTH_SHORT).show()
            }
            btnResta.setOnClickListener {
                recuperarValores()
                val rResta = calculadora(n1, n2, ::resta)
                Toast.makeText(applicationContext, "Resta = $rResta", Toast.LENGTH_SHORT).show()
            }
            btnMultiplicar.setOnClickListener {
                recuperarValores()
                val rMultiplicacion = calculadora(n1, n2, ::multiplicacion)
                Toast.makeText(applicationContext, "Multiplicación = $rMultiplicacion", Toast.LENGTH_SHORT).show()
            }
            btnDividir.setOnClickListener {
                recuperarValores()
                try {
                    throw Exception("Division por cero")
                }catch (e:Exception){
                    Toast.makeText(applicationContext, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
                }
                finally {
                    val rDivision = calculadora(n1, n2, ::division)
                    Toast.makeText(applicationContext, "División = $rDivision", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    private fun recuperarValores(){
        n1 = binding.etNumUno.text.toString().toDouble()
        n2 = binding.etNumDos.text.toString().toDouble()
    }
}

fun calculadora(n1:Double, n2:Double, operacion:(Double, Double)->Double):Double{
    return operacion(n1,n2)
}

fun suma(n1:Double, n2:Double):Double{
    return n1+n2
}
fun resta(n1:Double, n2:Double):Double{
    return n1-n2
}
fun multiplicacion(n1:Double, n2:Double):Double{
    return n1*n2
}
fun division(n1:Double, n2:Double):Double{
    return n1/n2
}