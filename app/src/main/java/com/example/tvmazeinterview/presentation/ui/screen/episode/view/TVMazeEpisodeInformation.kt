package com.example.tvmazeinterview.presentation.ui.screen.episode.view

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.presentation.ui.component.common.misc.HTMLSummary
import com.example.tvmazeinterview.presentation.ui.component.core.WebViewHtml
import com.example.tvmazeinterview.presentation.ui.component.typography.SectionHeading
import com.example.tvmazeinterview.presentation.utilities.extensions.Random

@Composable
fun TVMazeEpisodeInformation(tvEpisodeDetail: TVEpisodeDetail) {
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionHeading(title = stringResource(id = R.string.summary))
        HTMLSummary(tvEpisodeDetail)
    }
}

@Preview
@Composable
fun TVMazeEpisodeInformationPreview(){
    TVMazeEpisodeInformation(Random.TVEpisodeDetailRandom(summary = null))
}