@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.thorin.apps.ratibsholawatmaulidkitabkuning

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.dashboard.*
import com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.menu.KiblatActivity
import com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.menu.SholawatActivity
import com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.ratib.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedpref:SharedPref
    private lateinit var settingAct:SettingActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_sholawat, R.id.navigation_ratib, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide()
        sharedpref = SharedPref(this)
        if (sharedpref.loadNightModeState() === true)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    fun moveActRatibHadad(view: View) {
        val moveIntent = Intent(this, RatibAlhaddadActivity::class.java)
        startActivity(moveIntent)
    }

    fun moveActRatibAthos(view: View) {
        val moveIntent = Intent(this, RatibAlathosActivity::class.java)
        startActivity(moveIntent)
    }

    fun moveActHadadFadhilah(view: View) {
        val moveIntent = Intent(this, RatibAlhaddadFadhilah::class.java)
        startActivity(moveIntent)
    }

    fun moveActAthosFadhilah(view: View) {
        val moveIntent = Intent(this, RatibAthosFadhilah::class.java)
        startActivity(moveIntent)
    }

    fun moveActHadadHistory(view: View) {
        val moveIntent = Intent(this, RatibHadadHistory::class.java)
        startActivity(moveIntent)
    }

    fun moveActAthosHistory(view: View) {
        val moveIntent = Intent(this, RatibAthosHistory::class.java)
        startActivity(moveIntent)
    }

    fun masjidTerdekat(view: View) {
        val gmmIntentUri = Uri.parse("geo:0,0?q=Masjid")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)

    }

    fun moveQuran(view: View) {
        val moveIntent = Intent(this, QuranActivityOnline::class.java)
        startActivity(moveIntent)
    }

    fun moveAbout(view: View) {
        val moveIntent = Intent(this, AboutThorin::class.java)
        startActivity(moveIntent)
    }

    fun moveHijrah(view: View) {
        val moveIntent = Intent(this, SemangatHijrahActivity::class.java)
        startActivity(moveIntent)
    }

    fun moveNotif(view: View) {
        val moveIntent = Intent(this, NotifActivity::class.java)
        startActivity(moveIntent)
    }

    fun moveSetting(view: View) {
        val moveIntent = Intent(this, SettingActivity::class.java)
        startActivity(moveIntent)
    }

    fun moveQosidah(view: View) {
        val moveIntent = Intent(this, SholawatActivity::class.java)
        startActivity(moveIntent)
    }

    fun moveKiblat(view: View) {
        val moveIntent = Intent(this, KiblatActivity::class.java)
        startActivity(moveIntent)
    }
}