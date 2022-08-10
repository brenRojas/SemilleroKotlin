package com.example.democamara

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.democamara.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var resultLauncher: ActivityResultLauncher<Intent>
    lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == Activity.RESULT_OK){
                val data = result.data
                if (data != null){
                    val foto = data?.extras?.get("data") as Bitmap
                    binding.imgFoto.setImageBitmap(foto)
                }
                Toast.makeText(applicationContext, "Si se tomo foto $data", Toast.LENGTH_LONG).show()
            }else{
               Toast.makeText(applicationContext, "No se tomo foto", Toast.LENGTH_LONG).show()
            }
        }

        requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    // to do Tomar foto
                    tomarFoto()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Permiso necesario para ejecutar la cámara",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        binding.btnTomarFoto.setOnClickListener {
            solicitarPermisos()
        }

    }

    private fun solicitarPermisos() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            //to do "Tomar foto"
            tomarFoto()
            return
        }
        when {
            ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                //to do "Tomar foto"
                tomarFoto()
                //Se ejecuta cuando el permiso ha sido concedido
            }
            shouldShowRequestPermissionRationale(Manifest.permission.CAMERA) -> {
                //Se ejecuta cuando el usuario rechazo el permiso con anterioridad
                Toast.makeText(
                    applicationContext,
                    "Asigna el permiso en los ajustes",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                //Se ejecuta cuando es primera vez
                requestPermissionLauncher.launch(
                    Manifest.permission.CAMERA
                )
            }
        }

    }

    private fun tomarFoto(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(intent)

    }
}
