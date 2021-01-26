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
import kotlinx.android.synthetic.main.activity_webhijrah.*
import com.thorin.apps.ratibsholawatmaulidkitabkuning.MainActivity.*

class SemangatHijrahActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webhijrah)
        webHijrah.settings.javaScriptEnabled = true
        supportActionBar?.hide()

        webHijrah.webViewClient = object : WebViewClient() {

            override fun onReceivedError(view: WebView, errorCode: Int, description: String, failingUrl: String) {
                try {
                    webHijrah.stopLoading()
                } catch (e: Exception) {
                }
                try {
                    webHijrah.clearView()
                } catch (e: Exception) {
                }
                if (webHijrah.canGoBack()) {
                    webView.goBack()
                }
                webHijrah.loadUrl("about:blank")
                val alertDialog = AlertDialog.Builder(this@SemangatHijrahActivity).create()
                alertDialog.setTitle("Gagal Membuka")
                alertDialog.setMessage("""
                    Pastikan android anda terhubung ke internet lalu coba lagi !
                    
                    Info: Anda harus terhubung internet untuk menggunakan menu ini.
                """.trimIndent())
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", DialogInterface.OnClickListener { _: DialogInterface, _: Int ->
                    moveBack()
                })
                alertDialog.show()
                super.onReceivedError(webView, errorCode, description, failingUrl)
            }

        }
        webHijrah.webChromeClient = WebChromeClient()
        webHijrah.loadUrl("https://thorinapps1webviewhijrah.blogspot.com/")

    }
    override fun onKeyDown(keyCode:Int, event: KeyEvent):Boolean {
        if (event.action === KeyEvent.ACTION_DOWN)
        {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (webHijrah.canGoBack())
                    {
                        webHijrah.goBack()
                    }
                    else
                    {
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