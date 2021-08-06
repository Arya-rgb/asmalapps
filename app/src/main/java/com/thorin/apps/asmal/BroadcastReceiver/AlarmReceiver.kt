package com.thorin.apps.asmal.BroadcastReceiver

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.thorin.apps.asmal.view.MainActivity
import com.thorin.apps.asmal.R
import java.util.*

class AlarmReceiver : BroadcastReceiver() {

    companion object {
        const val EXTRA_TYPE = "type"
        const val TYPE_REPEATING = "repeating"
        const val EXTRA_MESSAGE = "message"
        private const val ID_REPEAT = 1234
    }

    override fun onReceive(context: Context, intent: Intent) {
        val type = intent.getStringExtra(EXTRA_TYPE)
        val notificationId = if (type.equals(TYPE_REPEATING, ignoreCase = true)) ID_REPEAT else return
        val message = intent.getStringExtra(EXTRA_MESSAGE) as String
        showAlarmNotif(context, message, notificationId)
    }

    private fun showAlarmNotif(context: Context, message: String, notificationId: Int) {

        val channelID = "HC02"
        val channelName = "Daily Reminder"

        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val notificationManagerCompat = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder = NotificationCompat.Builder(context, channelID)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_notif)
            .setContentTitle(context.getString(R.string.Daily_Reminder))
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ContextCompat.getColor(context, android.R.color.transparent))
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setSound(alarmSound)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(1000, 1000, 1000, 1000, 1000)
            builder.setChannelId(channelID)
            notificationManagerCompat.createNotificationChannel(channel)
        }

        val notificationBuilder = builder.build()
        notificationManagerCompat.notify(notificationId, notificationBuilder)

    }

    fun setAlarm(context: Context, type: String, message: String) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
            putExtra(EXTRA_TYPE, type)
        }
        val pendingIntent = PendingIntent.getBroadcast(context, ID_REPEAT, intent, 0)
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 19)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }
        val different = calendar.timeInMillis - System.currentTimeMillis()
        if (different > 0) {
            alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )
        }else{
            val time = System.currentTimeMillis() + AlarmManager.INTERVAL_DAY - different
            alarmManager.setInexactRepeating(
                AlarmManager.RTC_WAKEUP,
                time,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )
        }
        Toast.makeText(context, "Notif Al-Haddad On", Toast.LENGTH_SHORT).show()
    }

    fun cancelAlarm(context: Context, type: String) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val reqsCode = if (type.equals(TYPE_REPEATING, ignoreCase = true)) ID_REPEAT else 0
        val pendingIntent = PendingIntent.getBroadcast(context, reqsCode, intent, 0)

        pendingIntent.cancel()
        alarmManager.cancel(pendingIntent)
        Toast.makeText(context, "Notif Al-Haddad Off", Toast.LENGTH_SHORT).show()
    }


}