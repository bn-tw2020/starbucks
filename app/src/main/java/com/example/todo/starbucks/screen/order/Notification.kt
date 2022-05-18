package com.example.todo.starbucks.screen.order

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.todo.starbucks.screen.MainActivity

class Notification(
    private val context: Context,
) {

    private val channelID = "channelID"
    private val channelName = "channelName"
    private val description = "description"

    fun notify(name: String) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, "channelID")
            .setLargeIcon(BitmapFactory.decodeResource(context.resources,
                android.R.drawable.ic_dialog_alert))
            .setContentTitle("$name 주문했습니다.")
            .setContentText("현재 ${name}을 주문했습니다. 확인하고 있습니다.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setSmallIcon(android.R.drawable.ic_btn_speak_now)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelID, channelName, importance)
            channel.description = description

            notificationManager.createNotificationChannel(channel)
        } else {
            builder.setSmallIcon(android.R.mipmap.sym_def_app_icon)
        }
        notificationManager.notify(0, builder.build())
    }
}