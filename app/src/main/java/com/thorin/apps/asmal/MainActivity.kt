@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.thorin.apps.asmal

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
import com.thorin.apps.asmal.ui.asisten.catatamal.CatatAmalActivity
import com.thorin.apps.asmal.ui.dashboard.*
import com.thorin.apps.asmal.ui.menu.ratib.MenuRatibsActivity
import com.thorin.apps.asmal.ui.menu.sholawat.SholawatListActivity
import com.thorin.apps.asmal.ui.menu.tasbih.TasbihActivity
import com.google.android.gms.ads.MobileAds;


class MainActivity : AppCompatActivity() {

    private lateinit var sharedpref:SharedPref


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

}