package com.techcrunch.crunchynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.webkit.WebView
import com.techcrunch.crunchynews.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val webView = findViewById<WebView>(R.id.webView)
        val url = intent.getStringExtra("url")
        webView.loadUrl(url!!)
    }
}