package com.brenda.scannerqr

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.brenda.scannerqr.databinding.ActivityMainBinding
import android.widget.Toast

import com.journeyapps.barcodescanner.ScanContract

import com.journeyapps.barcodescanner.ScanOptions

import androidx.activity.result.ActivityResultLauncher
import com.brenda.scannerqr.ui.MapaFragment
import com.brenda.scannerqr.ui.TextoFragment
import com.brenda.scannerqr.ui.UrlFragment
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.journeyapps.barcodescanner.ScanIntentResult


class MainActivity : AppCompatActivity() {
    private lateinit var barcodeLauncher: ActivityResultLauncher<ScanOptions>

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Register the launcher and result handler
        barcodeLauncher = registerForActivityResult(
            ScanContract()
        ) { result: ScanIntentResult ->
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                //Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                val rc = result.contents
                val transaction = supportFragmentManager.beginTransaction()

                if(result.contents.contains("maps")){
                    transaction.replace(R.id.contenedor, MapaFragment(rc))
                }else if(result.contents.contains("http")){
                    transaction.replace(R.id.contenedor, UrlFragment(rc))
                } else{
                    transaction.replace(R.id.contenedor, TextoFragment(rc))
                }
                transaction.addToBackStack(null)
                transaction.commit()

            }
        }

        generarCodigoQr()

    }

    fun scan(view: android.view.View) {
        val option = ScanOptions()
        option.setOrientationLocked(false)
        option.setPrompt("Enfoca el código QR")
        option.setBeepEnabled(true)
        barcodeLauncher.launch(option)
    }

    fun generarCodigoQr(){

        try{
            var barcodeEncoder = BarcodeEncoder()
            var bitmap : Bitmap = barcodeEncoder.encodeBitmap("QR", BarcodeFormat.QR_CODE, 600, 400)
            binding.imgQr.setImageBitmap(bitmap)

        }catch (e:Exception){
            Log.e("Mensaje", e.message.toString())
        }
    }
}