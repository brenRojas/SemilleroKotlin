package com.example.demonotificacionespush.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.demonotificacionespush.NotificationActivity
import com.example.demonotificacionespush.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private val CHANNEL_NAME = "Notificaciones Urgentes"
    private val CHANNEL_DESCRIPTION = "Aqui llegan las Notificaciones Urgentes"
    private val CHANNEL_ID = "CHANNEL_PROMOCIONES"
    lateinit var manager: NotificationManager
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager


        remoteMessage.notification?.let {
            onCreatenotificationChannel()
            if (remoteMessage.data.isNotEmpty()) {
                createNotification(it.title.toString(), it.body.toString(), remoteMessage.data)
                Log.d("Mensaje", "data ${remoteMessage.data}")
            } else {
                createNotification(it.title.toString(), it.body.toString(), null)
            }
        }
    }

    override fun onNewToken(token: String) {
        //   super.onNewToken(token)
        Log.d("token", "token = $token")
    }

    fun onCreatenotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = CHANNEL_NAME
            var descriptionText = CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            manager.createNotificationChannel(channel)
        }
    }

    fun createNotification(title: String, contenido: String, datos: Map<String, String>? = null) {
        var intent = Intent(this, NotificationActivity::class.java)
        if (datos != null) {
            if (datos.size > 0) {
                datos.forEach {
                    intent.putExtra(it.key, it.value)
                }
            }
        }

        intent.putExtra("Titulo", title)
        intent.putExtra("Contenido", contenido)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(contenido)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
        manager.notify(0, builder.build())

    }

}