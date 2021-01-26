package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.dashboard

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging
import com.thorin.apps.ratibsholawatmaulidkitabkuning.BroadcastReceiver.AlarmReceiver
import com.thorin.apps.ratibsholawatmaulidkitabkuning.R
import kotlinx.android.synthetic.main.activity_notif.*

class NotifActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val PREFS_NAME = "setting_pref"
        private const val DAILY = "daily"
        private val TAG = NotifActivity::class.java.simpleName
    }


    private lateinit var mSharedPreferences: SharedPreferences
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif)

        btn_subscribe.setOnClickListener {
            FirebaseMessaging.getInstance().subscribeToTopic("news")
            val msg = getString(R.string.msg_subscribed)
            Log.d(TAG, msg)
            Toast.makeText(this@NotifActivity, msg, Toast.LENGTH_SHORT).show()
        }


        mSharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        alarmReceiver = AlarmReceiver()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (supportActionBar != null) {
            supportActionBar?.title = getString(R.string.title_setting)
        }


        set_reminder.isChecked = mSharedPreferences.getBoolean(DAILY, false)
        set_reminder.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                alarmReceiver.setAlarm(applicationContext, AlarmReceiver.TYPE_REPEATING,getString(R.string.daily_hadad))
            } else {
                alarmReceiver.cancelAlarm(applicationContext, AlarmReceiver.TYPE_REPEATING)
            }
            saveChange(isChecked)
        }
    }

    private fun saveChange(value: Boolean) {
        val editor = mSharedPreferences.edit()
        editor.putBoolean(DAILY, value)
        editor.apply()
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}