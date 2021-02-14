package com.thorin.apps.asmal.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thorin.apps.asmal.R

class AboutThorin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val actionbar = supportActionBar
        actionbar?.title = "Tentang Kami"
        actionbar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_about_thorin)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}