package com.brenda.repas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewClient
import android.widget.Toast
import com.brenda.repas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding .root)

        binding.myWebView.setWebViewClient(WebViewClient())
        binding.myWebView.settings.javaScriptEnabled = true
    //binding.myWebView.loadUrl("https://facebook.com")

        //cargarLista()
        //cargarHashMaps()
        //convertirStringToArray()
        reto()
    }

    fun reto(){
        var cadena = "Este es el texto del reto de lógica. Con esto van a mejorar su razonamiento"
        var arreglo = cadena.split(" ")
        var palabraLarga = ""
        var maslarga = 0

        println(arreglo)
        //1. la palabra más corta
       arreglo.forEach{
           if(it.length > maslarga ){
               maslarga = it.length
               palabraLarga = maslarga.toString()
               Toast.makeText(applicationContext, palabraLarga, Toast.LENGTH_SHORT).show()
           }
       }


        //2. La palabra más larga


        //3. La palabra que más se repite

    }

    fun convertirStringToArray(){
        var cadena = "Jose|luis|Sergio2|lili|sergio1|david"
        var arreglo = cadena.split("|")
        arreglo.forEach{
            Log.d("mensaje", it)
        }
    }

    fun cargarHashMaps(){
        var mapa = HashMap<String,Any>()
        mapa.put("nombre", "Jose")
        mapa["edad"] = 20
        mapa["casado"]=false

        var edad = mapa.get("edad")
        var edad2 = mapa["edad"]

        mapa.forEach{ t, u ->
            Log.d("Mensaje", "t es $t")
            Log.d("Mensaje", "t es $u")
        }
        for(llave in mapa.keys){
            Log.d("Mensaje", "La llave $llave es ${mapa[llave]}")
        }
    }

    fun cargarLista(){
        var setList = mutableSetOf("Lun","Mar","Mier","Jue","Vie", "Sab", "Dom")
        setList.forEach{
            Log.d("mensaje", "Segundo recorrdio ///")
        }
        setList.add("Lunes")
        setList.add("Dom")
        setList.forEach{
            Log.d("mensaje", it)
        }

        Log.d("mensaje", "Recorriendo arraylist")

        val x = ArrayList<String>()
        x.add("Jose")
        x.add("Luis")
        x.add("Pedro")
        x.add("Jose")
        x.add("Ana")
        x.add("Luis")

        x.forEach{
            Log.d("mensaje", it)
        }


        Log.d("mensaje", "Recorriendo arraylist")

        val listaSinRepetir  = x.toList().toSet()
        Log.d("mensaje", "Recorriendo arrayliss convertido a set")
        listaSinRepetir.forEach{
            Log.d("mensaje", it)
        }
    }

}