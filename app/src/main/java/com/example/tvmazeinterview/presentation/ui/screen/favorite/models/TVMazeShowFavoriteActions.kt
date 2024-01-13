package com.example.tvmazeinterview.presentation.ui.screen.favorite.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.navigation.TVMazeDestinations
import com.example.tvmazeinterview.presentation.ui.navigation.destination.navigate
import com.example.tvmazeinterview.presentation.ui.viewmodel.favorite.TVMazeShowFavoriteViewModel
import com.example.tvmazeinterview.presentation.ui.viewmodel.home.TVMazeShowHomeViewModel

data class TVMazeShowFavoriteActions(
    val onTVShowClicked: (TVShow) -> Unit,
    val onFavorite: (TVShow) -> Unit
)

@Composable
fun rememberTVMazeShowFavoriteActions(
    viewModel: TVMazeShowFavoriteViewModel,
    navController: NavController
) : TVMazeShowFavoriteActions {
    return remember {
        TVMazeShowFavoriteActions(
            onTVShowClicked = {
                navController.navigate(TVMazeDestinations.TVShowDetailDestination, mapOf("id" to it.id.toString()))
            },
            onFavorite = {
                viewModel.toggleFavorite(it)
            }
        )
    }
}
