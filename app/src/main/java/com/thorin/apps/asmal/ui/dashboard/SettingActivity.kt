package com.thorin.apps.asmal.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.thorin.apps.asmal.R
import kotlinx.android.synthetic.main.activity_setting.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class SettingActivity : AppCompatActivity() {
    private lateinit var sharedpref:SharedPref
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        sharedpref = SharedPref(this)
        if (sharedpref.loadNightModeState() === true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        super.onCreate(savedInstanceState)
        val actionbar = supportActionBar
        actionbar?.title = "Pengaturan"
        actionbar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_setting)

        sharedpref = SharedPref(this)
        if (sharedpref.loadNightModeState() === true) {
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

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView3)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("B46E966AE01DF822F8A7F5B86DDE8300"))
                .build()
        )

    }

    public override fun onPause() {
        mAdView.pause()
        super.onPause()
    }

    // Called when returning to the activity
    public override fun onResume() {
        super.onResume()
        mAdView.resume()
    }

    // Called before the activity is destroyed
    public override fun onDestroy() {
        mAdView.destroy()
        super.onDestroy()
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
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}