package com.thorin.apps.asmal.view.ui.amalnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.thorin.apps.asmal.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {

    private lateinit var adView: AdView

    private var _binding: ActivityAddNotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adRequest = AdRequest.Builder().build()
//        binding.adView5.loadAd(adRequest)

    }

    override fun onDestroy() {
        adView.destroy()
        super.onDestroy()
    }

}