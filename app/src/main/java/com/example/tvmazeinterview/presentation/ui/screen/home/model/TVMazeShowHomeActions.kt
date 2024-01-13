package com.example.tvmazeinterview.presentation.ui.screen.home.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.navigation.TVMazeDestinations
import com.example.tvmazeinterview.presentation.ui.navigation.TVMazeDestinations.TVShowDetailDestination
import com.example.tvmazeinterview.presentation.ui.navigation.destination.navigate
import com.example.tvmazeinterview.presentation.ui.viewmodel.home.TVMazeShowHomeViewModel
import com.example.tvmazeinterview.presentation.utilities.extensions.normalize

data class TVMazeShowHomeActions(
    val onRetry: () -> Unit,
    val onQueryChange: (String) -> Unit,
    val onTVShowClicked: (TVShow) -> Unit,
    val onFavorite: (TVShow) -> Unit,
    val onNavigateToFavorites: () -> Unit = {},
)

@Composable
fun rememberTVMazeShowHomeActions(
    shows: LazyPagingItems<TVShow>,
    viewModel: TVMazeShowHomeViewModel,
    navController: NavController
) : TVMazeShowHomeActions{
    return remember {
        TVMazeShowHomeActions(
            onRetry = { shows.retry() },
            onQueryChange = {
                viewModel.setQuery(it)
            },
            onTVShowClicked = {
                navController.navigate(TVShowDetailDestination, mapOf("id" to it.id.toString()))
            },
            onFavorite = {
                viewModel.setFavorite(it)
            },
            onNavigateToFavorites = {
                navController.navigate(TVMazeDestinations.TVShowFavorites)
            }
        )
    }
}