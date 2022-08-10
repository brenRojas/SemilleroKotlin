package com.brenda.demofirebasestorage

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.brenda.demofirebasestorage.databinding.ActivityMainBinding
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {

    lateinit var resultLauncherImage: ActivityResultLauncher<Intent>
    lateinit var resultLauncherArchivo: ActivityResultLauncher<Intent>
    lateinit var btnImagen:Button
    lateinit var btnArchivo:Button
    lateinit var mStorageInstance: FirebaseStorage
    lateinit var mStorageReference: StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnImagen = findViewById(R.id.btnSubirImagen)
        btnArchivo = findViewById(R.id.btnSubirArchivo)
        mStorageInstance = FirebaseStorage.getInstance()
        mStorageReference = mStorageInstance.getReference("Documentos")

        resultLauncherImage=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode== Activity.RESULT_OK){
                val data: Intent?=result.data
                if(data!= null){
                    val imageuri = data?.data
                    val imageStream = imageuri?.let { contentResolver.openInputStream(it) }
                    val imagenSeleccionada = BitmapFactory.decodeStream(imageStream)
                    subirFotoFirebase(imagenSeleccionada)
                }
            }else{
                Toast.makeText(applicationContext,"No se selecciono imagen", Toast.LENGTH_LONG).show()
            }
        }

        resultLauncherArchivo =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode== Activity.RESULT_OK){
                val data: Intent?=result.data
                if(data!= null){
                    try{
                        var returnUri = data?.data!!
                        val uriString = data.toString()
                        val myFile = File(uriString)
                        Log.d("mensaje","PDF: $uriString")
                        subirPdfFirebase(myFile,returnUri)
                    }catch (e: FileNotFoundException){
                        e.printStackTrace()
                        Log.e("mensaje", "File not found. ${e.message}");
                    }
                }
            }else{
                Toast.makeText(applicationContext,"No se selecciono imagen", Toast.LENGTH_LONG).show()
            }
        }

        btnImagen.setOnClickListener {
            val intent= Intent()
            intent.setAction(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            resultLauncherImage.launch(intent)
        }

        btnArchivo.setOnClickListener {
            val intent = Intent()
            intent.setAction(Intent.ACTION_GET_CONTENT)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.type = "*/*"
            resultLauncherArchivo.launch(intent)
        }


    }

    fun subirFotoFirebase(imagen: Bitmap){
        val baos = ByteArrayOutputStream()
        imagen.compress(Bitmap.CompressFormat.JPEG,100,baos)
        val data = baos.toByteArray()

        var uploadTask = mStorageReference
            .child("imagen${(0..500).random()}")
            .putBytes(data)


        uploadTask.addOnSuccessListener {
            it.storage.downloadUrl.addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Toast.makeText(this,"Imagen cargada correctamente", Toast.LENGTH_LONG).show()
                    Log.i("Url","Archivo uri: ${task.result}")
                }
                else{
                    Toast.makeText(this,"Error al subir imagen", Toast.LENGTH_LONG).show()
                }
            }
        }

        uploadTask.addOnFailureListener{
            Toast.makeText(this,"Ocurrió un error al cargar imagen", Toast.LENGTH_LONG).show()
        }
    }

    fun subirPdfFirebase(pdf: File,uri: Uri){
        try{
            var refenciaPdf = mStorageReference
                .child("archivos${(0..999).random()}")
            var uploadTask = refenciaPdf.putFile(uri)
            uploadTask.addOnSuccessListener {
                it.storage.downloadUrl.addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Documento cargado correctamente", Toast.LENGTH_LONG).show()
                        Log.i("Url","Archivo uri: ${task.result}")
                    }
                    else{
                        Toast.makeText(this,"Error al subir imagen", Toast.LENGTH_LONG).show()
                    }
                }
            }
            uploadTask.addOnFailureListener{
                it.printStackTrace()
                Toast.makeText(this,"Ocurrió un error al cargar archivo",Toast.LENGTH_LONG).show()
            }
        }catch(e:Exception){
            Log.e("mensaje",e.message.toString())
            e.printStackTrace()
            Toast.makeText(this,"Ocurrió un error al cargar archivo",Toast.LENGTH_LONG).show()

        }
        finally {
        }
    }
}