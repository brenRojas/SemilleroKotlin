package com.example.demowidget2

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var imgUmbrella: ImageView
    lateinit var imgBedtime: ImageView
    lateinit var imgMouse: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAnterior: Button = findViewById(R.id.btn_anterior)
        val btnSiguiente: Button = findViewById(R.id.btn_siguiente)
        imgUmbrella = findViewById(R.id.img_umbrella)
        imgBedtime  = findViewById(R.id.img_beedtime)
        imgMouse    = findViewById(R.id.img_mouse)

        btnAnterior.setOnClickListener{
            cambiarImagen(it.id)
        }
        btnSiguiente.setOnClickListener{
            cambiarImagen(it.id)
        }
    }

    fun mostrarSiguienteImagen(view: View){
        cambiarImagen(view.id)
    }

    fun cambiarImagen(id:Int){
        when (id) {
            R.id.btn_anterior -> {
                if (imgUmbrella.visibility == View.VISIBLE){
                    imgUmbrella.visibility = View.INVISIBLE
                    imgBedtime.visibility = View.VISIBLE
                    imgMouse.visibility = View.INVISIBLE
                }else if (imgBedtime.visibility == View.VISIBLE){
                    imgUmbrella.visibility = View.INVISIBLE
                    imgBedtime.visibility = View.INVISIBLE
                    imgMouse.visibility = View.VISIBLE
                } else if (imgMouse.visibility == View.VISIBLE){
                    imgUmbrella.visibility = View.VISIBLE
                    imgBedtime.visibility = View.INVISIBLE
                    imgMouse.visibility = View.INVISIBLE
                }
            }
            R.id.btn_siguiente -> {
                if (imgUmbrella.visibility == View.VISIBLE){
                    imgUmbrella.visibility = View.INVISIBLE
                    imgBedtime.visibility = View.INVISIBLE
                    imgMouse.visibility = View.VISIBLE
                }else if (imgBedtime.visibility == View.VISIBLE){
                    imgUmbrella.visibility = View.VISIBLE
                    imgBedtime.visibility = View.INVISIBLE
                    imgMouse.visibility = View.INVISIBLE
                } else if (imgMouse.visibility == View.VISIBLE){
                    imgUmbrella.visibility = View.INVISIBLE
                    imgBedtime.visibility = View.VISIBLE
                    imgMouse.visibility = View.INVISIBLE
                }
            }
        }
    }
}