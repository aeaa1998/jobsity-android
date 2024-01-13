package com.example.tvmazeinterview.presentation.ui.component.entity.episode

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.presentation.ui.component.core.Width
import com.example.tvmazeinterview.presentation.ui.screen.detail.view.TVMazeEpisodeImage

@Composable
fun TVMazeEpisodeRow(
    episode: TVEpisode,
    onEpisodeClick: (TVEpisode) -> Unit = {}
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().clickable { onEpisodeClick(episode) }
    ) {
        episode.image?.let { image ->
            TVMazeEpisodeImage(
                image,
                modifier = Modifier
                    .width(100.dp)
                    .height(70.dp)
                    .background(MaterialTheme.colorScheme.background)
            )

            Width(width = 8.dp)

            Column {
                Text(
                    text = "${episode.number}.  ${episode.name}",
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = stringResource(id = R.string.episode_runtime, episode.runtime)
                )
            }

        }
    }
}

@Preview
@Composable
fun TVMazeEpisodeRowPreview(){
    TVMazeEpisodeRow(TVEpisode(
        id = 1,
        name = "Episode",
        number = 1,
        season = 1,
        summary = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>",
        image = "https://static.tvmaze.com/uploads/images/medium_portrait/31/78286.jpg",
        runtime = 65
    ))
}