package com.example.tvmazeinterview.presentation.ui.screen.episode.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.presentation.ui.component.common.misc.Rating
import com.example.tvmazeinterview.presentation.utilities.extensions.Random
import com.example.tvmazeinterview.presentation.utilities.extensions.format
import com.example.tvmazeinterview.presentation.utilities.extensions.toDate


private val textColor: Color
    @Composable
    get() = MaterialTheme.colorScheme.onSecondaryContainer

@Composable
private fun TVMazeEpisodeTitle(tvEpisodeDetail: TVEpisodeDetail){
    Text(
        text = tvEpisodeDetail.name,
        style = MaterialTheme.typography.headlineMedium,
        color = textColor
    )
}

@Composable
private fun TVMazeEpisodeAirDate(tvEpisodeDetail: TVEpisodeDetail){
    (tvEpisodeDetail.airDate?.toDate()?.format() ?: tvEpisodeDetail.airDate)?.let { airDateString ->
        Text(
            text = airDateString,
            fontSize = 12.sp,
            color = textColor
        )
    }
}

@Composable
private fun TVMazeEpisodeMetadata(tvEpisodeDetail: TVEpisodeDetail){

    Text(
        text = stringResource(id = R.string.episode_season_number, tvEpisodeDetail.season),
        style = MaterialTheme.typography.titleSmall,
        color = textColor
    )

    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)){
        Text(
            text = stringResource(id = R.string.episode_number, tvEpisodeDetail.number),
            style = MaterialTheme.typography.bodySmall,
            color = textColor
        )

        Text(
            text = stringResource(id = R.string.episode_runtime, tvEpisodeDetail.runtime),
            style = MaterialTheme.typography.bodySmall,
            color = textColor
        )
    }

    TVMazeEpisodeAirDate(tvEpisodeDetail)
}

@Composable
fun TVMazeEpisodeHeader(
    tvEpisodeDetail: TVEpisodeDetail
) {
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        TVMazeEpisodeTitle(tvEpisodeDetail)

        TVMazeEpisodeMetadata(tvEpisodeDetail)

        Rating(tvEpisodeDetail)
    }
}


@Preview(showBackground = true)
@Composable
fun TVMazeEpisodeHeaderPreview() {
    TVMazeEpisodeHeader(Random.TVEpisodeDetailRandom())
}