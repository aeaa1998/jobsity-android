package com.example.tvmazeinterview.presentation.ui.component.core

import android.graphics.Color
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewHtml(
    html: String,
    modifier: Modifier = Modifier,
    transformWebView: (WebView) -> Unit = {
        it.setBackgroundColor(Color.TRANSPARENT)
    }
) {

    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                this.webViewClient = WebViewClient()
                this.loadData("""
                    |<body style=\"margin: 0; padding: 0\">$html</body>
                    |
                    |<style type="text/css">
                    | html, body {
                    |      width: 100%;
                    | }
                    | p, html, body {
                    |   padding: 0;
                    |   margin: 0;
                    | }
                    |</style>
                    
                """.trimMargin(), "text/html", "UTF-8")
                transformWebView(this)
            }
        },
        update = { webView ->
            webView.loadData(html, "text/html", "UTF-8")
            transformWebView(webView)
        }
    )
}