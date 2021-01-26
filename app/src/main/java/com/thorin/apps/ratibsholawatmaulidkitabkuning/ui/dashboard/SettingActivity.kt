package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.thorin.apps.ratibsholawatmaulidkitabkuning.R
import kotlinx.android.synthetic.main.activity_setting.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class SettingActivity : AppCompatActivity() {
    private lateinit var sharedpref:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedpref = SharedPref(this)
        if (sharedpref.loadNightModeState() === true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        sharedpref = SharedPref(this)
        if (sharedpref.loadNightModeState() === true)
        {
            dark_mode.isChecked = true
        }

        dark_mode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sharedpref.setNightModeState(true)

            } else {
                sharedpref.setNightModeState(false)

            }
            restartApp()
        }
    }
    private fun restartApp() {
        val i = Intent(applicationContext, SettingActivity::class.java)
        startActivity(i)
        finish()
    }

    fun reportEmail(view: View) {

        val i = Intent(Intent.ACTION_SEND)
        i.type = "message/rfc822"
        i.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>("thorin.contact@gmail.com"))
        i.putExtra(Intent.EXTRA_SUBJECT, "Laporan/Masukan Asmal")
        i.putExtra(Intent.EXTRA_TEXT, " ")
        try
        {
            startActivity(Intent.createChooser(i, "Send mail..."))
        }
        catch (ex:android.content.ActivityNotFoundException) {
            Toast.makeText(this@SettingActivity, "Tidak ada aplikasi email terinstall", Toast.LENGTH_SHORT).show()
        }
    }
}