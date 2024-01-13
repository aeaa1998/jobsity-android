package com.example.tvmazeinterview.presentation.ui.screen.episode.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.presentation.state.core.AppBarStateLaunchedEffect
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.component.entity.episode.TVMazeEpisodeDetailImage
import com.example.tvmazeinterview.presentation.ui.theme.paddings
import com.example.tvmazeinterview.presentation.utilities.extensions.Random

@Composable
fun TVMazeEpisodeSuccessContent(tvEpisodeDetail: TVEpisodeDetail) {

    //Handle the app bar title
    AppBarStateLaunchedEffect {
        setTitle(UIText.Raw(tvEpisodeDetail.name))
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TVMazeEpisodeDetailImage(
            tvEpisodeDetail,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            contentScale = ContentScale.FillWidth
        )

        Column(
            Modifier.padding(MaterialTheme.paddings.medium),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TVMazeEpisodeHeader(tvEpisodeDetail)

            TVMazeEpisodeInformation(tvEpisodeDetail)
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun TVEpisodeSuccessContentPreview(){
    TVMazeEpisodeSuccessContent(Random.TVEpisodeDetailRandom(summary = null))
}