package com.brenda.democapturapantalla

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.brenda.democapturapantalla.databinding.ActivityMainBinding
import java.lang.Exception
import android.os.Environment
import android.text.format.DateFormat
import java.io.File
import java.io.FileOutputStream
import java.util.*
import android.content.Intent
import android.net.Uri
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mPath : String
    lateinit var imageFile : File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCapturar.setOnClickListener {
            saveScreenshot(takeScreenshot())
        }

        binding.btnMostrar.setOnClickListener {
            openScreenshot(imageFile)
        }
    }

    private fun takeScreenshot() : Bitmap {
        var view:View
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        view.invalidate();
        final Bitmap bmp =  view.getDrawingCache();
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
    }

    private fun saveScreenshot(bitmap: Bitmap) {
        val now = Date()
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)
        try {
            // nombre y ruta de la imagen a incluir
            mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg"
            imageFile = File(mPath)
            val outputStream = FileOutputStream(imageFile)
            val quality = 100
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
            outputStream.flush()
            outputStream.close()
        } catch (e: Throwable) {
            // Captura los distintos errores que puedan surgir
            e.printStackTrace()
        }
    }

    private fun openScreenshot(imageFile: File) {
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        val uri: Uri = Uri.fromFile(imageFile)
        intent.setDataAndType(uri, "image/*")
        startActivity(intent)
    }


}