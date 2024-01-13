package com.example.tvmazeinterview.presentation.ui.component.common.misc

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.traits.interfaces.Summarizes
import com.example.tvmazeinterview.presentation.ui.component.core.WebViewHtml

@Composable
fun HTMLSummary(summarize : Summarizes){
    val summary = summarize.summary
    if (summary != null){
        WebViewHtml(
            html = summary,
            modifier = Modifier.fillMaxWidth()
        ){ webView ->
            webView.setBackgroundColor(Color.TRANSPARENT)
            webView.settings.defaultFontSize = 14
        }
    }else{
        Text(text = stringResource(id = R.string.summary_not_available))
    }
}