package com.thorin.apps.asmal.view.ui.menu.ratib

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.thorin.apps.asmal.R


class MenuRatibsActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_ratibs)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView1)
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
}

