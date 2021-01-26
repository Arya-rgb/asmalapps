package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.menu

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import com.thorin.apps.ratibsholawatmaulidkitabkuning.MainActivity
import com.thorin.apps.ratibsholawatmaulidkitabkuning.R
import kotlinx.android.synthetic.main.activity_kiblat.*
import kotlinx.android.synthetic.main.activity_quran_online.*

class KiblatActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kiblat)
        webkiblat.settings.javaScriptEnabled = true
        supportActionBar?.hide()
        webkiblat.webViewClient = object : WebViewClient() {

        }
        webkiblat.loadUrl("https://qiblafinder.withgoogle.com")

    }
    }

