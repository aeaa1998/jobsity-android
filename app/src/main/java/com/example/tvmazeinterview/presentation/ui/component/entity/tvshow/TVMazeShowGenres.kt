package com.example.tvmazeinterview.presentation.ui.component.entity.tvshow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.theme.paddings

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TVMazeShowGenres(tvShow: TVShow){
    FlowRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tvShow.genres.forEach { genre ->
            Surface(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clip(MaterialTheme.shapes.small)
            ) {
                Text(
                    text = genre,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(
                        vertical = MaterialTheme.paddings.small,
                        horizontal = MaterialTheme.paddings.medium
                    )
                )
            }
        }
    }
}