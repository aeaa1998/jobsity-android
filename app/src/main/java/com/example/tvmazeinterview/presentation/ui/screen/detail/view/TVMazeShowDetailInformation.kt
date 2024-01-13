package com.example.tvmazeinterview.presentation.ui.screen.detail.view

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.component.common.misc.HTMLSummary
import com.example.tvmazeinterview.presentation.ui.component.core.WebViewHtml
import com.example.tvmazeinterview.presentation.ui.component.typography.SectionHeading
import com.example.tvmazeinterview.presentation.utilities.extensions.text


@Composable
fun TVMazeShowDetailInformation(tvShow: TVShow){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            SectionHeading(title = stringResource(id = R.string.summary),)
            HTMLSummary(tvShow)
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            SectionHeading(title = stringResource(id = R.string.schedule),)
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                val schedule = tvShow.schedule
                schedule.days.forEach { day ->
                    Row {
                        Text(text = "${day.text.text} - ${schedule.time}")
                    }
                }
            }

        }
    }
}