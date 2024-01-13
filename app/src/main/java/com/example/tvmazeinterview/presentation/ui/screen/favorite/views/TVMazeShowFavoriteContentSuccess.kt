package com.example.tvmazeinterview.presentation.ui.screen.favorite.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.screen.favorite.models.TVMazeShowFavoriteActions
import com.example.tvmazeinterview.presentation.ui.screen.home.view.TVMazeShowCardView
import com.example.tvmazeinterview.presentation.utilities.extensions.Random


@Composable
fun TVMazeShowFavoriteContentSuccess(
    shows: List<TVShow>,
    actions: TVMazeShowFavoriteActions
){
    val verticalScrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(verticalScrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        shows.forEach {
            TVMazeShowCardView(tvShow = it, onTVShowFavorite = actions.onFavorite, onTVShowClicked = actions.onTVShowClicked)
        }
    }
}


@Preview
@Composable
fun TVMazeShowFavoriteContentSuccessPreview(){
    TVMazeShowFavoriteContentSuccess(
        List(10) {
            Random.TVShowRandom(null)
        },
        TVMazeShowFavoriteActions({}, {})
    )
}