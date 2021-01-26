package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.dashboard

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
import kotlinx.android.synthetic.main.activity_quran_online.*

class QuranActivityOnline : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran_online)
        webView.settings.javaScriptEnabled = true
        supportActionBar?.hide()

        webView.webViewClient = object : WebViewClient() {

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                try {
                    webView.stopLoading()
                } catch (e: Exception) {
                }
                try {
                    webView.clearView()
                } catch (e: Exception) {
                }
                if (webView.canGoBack()) {
                    webView.goBack()
                }
                webView.loadUrl("about:blank")
                val alertDialog = AlertDialog.Builder(this@QuranActivityOnline).create()
                alertDialog.setTitle("Gagal Membuka")
                alertDialog.setMessage("""
                    Pastikan android anda terhubung ke internet lalu coba lagi !
                    
                    Info: Surat yang pernah terbuka secara online akan otomatis tersimpan dan tersedia saat offline.
                """.trimIndent())
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", DialogInterface.OnClickListener { _: DialogInterface, _: Int ->
                       moveBack()
                })
                alertDialog.show()
                super.onReceivedError(webView, errorCode, description, failingUrl)
            }

        }

        webView.webChromeClient = WebChromeClient()
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState)
        } else {
            webView.loadUrl("https://litequran.net")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState) // output would be a WebBackForwardList
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.action === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (webView.canGoBack()) {
                        webView.goBack()
                    } else {
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
    fun moveBack() {
        val moveIntent = Intent(this, MainActivity::class.java)
        startActivity(moveIntent)
    }

}