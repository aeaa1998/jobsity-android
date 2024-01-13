package com.example.tvmazeinterview.presentation.ui.screen.detail.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.season.TVSeason
import com.example.tvmazeinterview.presentation.ui.component.core.Height
import com.example.tvmazeinterview.presentation.ui.component.entity.episode.TVMazeEpisodeRow

@Composable
private fun TVMazeShowDetailSeasonTitle(season: TVSeason, expanded: Boolean, onExpand: () -> Unit){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.season_title, season.number.toString()),
            style = MaterialTheme.typography.titleMedium
        )

        IconButton(onClick = onExpand) {
            Icon(
                imageVector = if (expanded) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                contentDescription = ""
            )
        }

    }
}

@Composable
private fun TVMazeShowDetailSeason(season: TVSeason, onEpisodeClick: (TVEpisode) -> Unit){
    var expanded by remember {
        mutableStateOf(false)
    }
    Column {
        TVMazeShowDetailSeasonTitle(season, expanded){
            expanded = !expanded
        }
        if (expanded) {
            Height(height = 8.dp)
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                season.episodes.forEach { episode ->
                    TVMazeEpisodeRow(episode, onEpisodeClick)

                    Divider()
                }
            }
        }

    }
}

@Composable
fun TVMazeShowDetailSeasons(
    seasons: List<TVSeason>,
    onEpisodeClick: (TVEpisode) -> Unit
){
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        seasons.forEach { season ->
            TVMazeShowDetailSeason(season, onEpisodeClick)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Preview(){
    TVMazeShowDetailSeason(
        TVSeason(
            number= 1,
            episodes = List(8) {
                TVEpisode(
                    id = 1,
                    name = "Episode",
                    number = it,
                    season = 1,
                    summary = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>",
                    image = "https://static.tvmaze.com/uploads/images/medium_portrait/31/78286.jpg",
                    runtime = 65
                )
            }
        ),
        {}
    )
}