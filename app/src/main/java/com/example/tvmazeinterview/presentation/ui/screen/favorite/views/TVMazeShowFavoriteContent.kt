package com.example.tvmazeinterview.presentation.ui.screen.favorite.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.component.core.Height
import com.example.tvmazeinterview.presentation.ui.screen.favorite.models.TVMazeShowFavoriteActions
import com.example.tvmazeinterview.presentation.ui.theme.paddings

@Composable
fun TVMazeShowFavoriteContent(
    shows: List<TVShow>,
    actions: TVMazeShowFavoriteActions
){
    if (shows.isEmpty()){
        Column(Modifier.padding(MaterialTheme.paddings.medium)) {
            Text(
                text = stringResource(id = R.string.no_favorites_found_title),
                style = MaterialTheme.typography.headlineMedium
            )
            Height(height = 8.dp)
            Text(
                text = stringResource(id = R.string.no_favorites_found_message),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }else{
        TVMazeShowFavoriteContentSuccess(shows = shows, actions = actions)
    }
}


@Preview
@Composable
fun TVMazeShowFavoriteContentPreview(){
    TVMazeShowFavoriteContent(
//        List(10) {
//            Random.TVShowRandom(null)
//        }
        emptyList(),
        TVMazeShowFavoriteActions({}, {})
    )
}