package com.thorin.apps.asmal.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.google.firebase.auth.FirebaseAuth
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.ActivitySplashScreenBinding
import com.thorin.apps.asmal.view.ui.dashboard.SharedPref
import java.util.logging.Handler

class SplashScreen : AppCompatActivity() {

    private var _binding: ActivitySplashScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedpref: SharedPref
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        supportActionBar?.hide()

        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        //add fade up animation for splash screen
        YoYo.with(Techniques.FadeInUp)
            .duration(5000)
            .playOn(binding.imgSplash)

        sharedpref = SharedPref(this)
        if (sharedpref.loadNightModeState())
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            if (null != user) {
                val menuIntent = Intent(this, MainActivity::class.java)
                startActivity(menuIntent)
                finish()
            } else {
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
                finish()
            }
        }, 3000)

    }


}