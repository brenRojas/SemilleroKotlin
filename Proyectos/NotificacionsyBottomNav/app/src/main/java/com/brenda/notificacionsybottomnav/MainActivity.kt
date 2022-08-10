package com.brenda.notificacionsybottomnav

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.brenda.notificacionsybottomnav.databinding.ActivityMainBinding
import com.brenda.notificacionsybottomnav.ui.fragments.NotificationFragment
import com.brenda.notificacionsybottomnav.ui.fragments.SegundoFragment
import com.brenda.notificacionsybottomnav.ui.fragments.TercerFragment

class MainActivity : AppCompatActivity() {
    private val CHANNEL_ID: String = "Alarmas"
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavBar.setOnNavigationItemSelectedListener{ menuItem ->
            when(menuItem.itemId){
                R.id.item_menu_uno -> {
                    Toast.makeText(applicationContext,"Uno", Toast.LENGTH_SHORT).show()
                    cambiarFragmento(1)
                    true
                }
                R.id.item_menu_dos -> {
                    cambiarFragmento(2)
                    Toast.makeText(applicationContext,"Dos", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item_menu_tres -> {
                    cambiarFragmento(3)
                    Toast.makeText(applicationContext,"Tres", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
        cambiarFragmento(1)
        createNotificationChannel()
    }

    fun cambiarFragmento(opcion:Int){
        val newFragment = when(opcion){
            1 -> {
                NotificationFragment()
            }
            2 -> {
                SegundoFragment()
            }
            else -> {
                TercerFragment()
            }
        }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.contenedor, newFragment)
        //transaction.addToBackStack(null)
        transaction.commit()
    }

    fun mostrarNotificacionNormal(){
        val intent = Intent(this, MainActivity2::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        intent.putExtra("nombre", "Juanito")

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ise_camera)
            .setContentTitle("My notification")
            .setContentText("Hello World!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }


    }
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Categoria Uno"
            val descriptionText = "Notificaciones categoria 1"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }



    fun mostrarNotificacioLarga() {
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ise_notifications)
            .setContentTitle("My notification")
            .setContentText("Much longer text that cannot fit one line...")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
                /*
                 .bigPicture(getBitmapFromVectorDrawable(applicationContext,R.drawable.ic_baseline_moped_24))
                .bigLargeIcon(null)
                */
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    }


    fun getBitmapFromVectorDrawable(context: Context?, drawableId: Int): Bitmap? {
        var drawable = ContextCompat.getDrawable(context!!, drawableId)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = DrawableCompat.wrap(drawable!!).mutate()
        }
        val bitmap = Bitmap.createBitmap(
            drawable!!.intrinsicWidth,
            drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
        drawable.draw(canvas)
        return bitmap
    }
}