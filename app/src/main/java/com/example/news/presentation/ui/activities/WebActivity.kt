package com.example.news.presentation.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.news.Constants
import com.example.news.R
import com.example.news.data.model.api_response.Article
import kotlinx.android.synthetic.main.activity_web.*
import timber.log.Timber

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val url: String? = intent.getStringExtra(Constants.NEWS_URL)
        webViewId.apply {
            webViewClient = WebViewClient()

            if (url != null) {
                Timber.e(url)
                loadUrl(url)
            }
        }
    }
}