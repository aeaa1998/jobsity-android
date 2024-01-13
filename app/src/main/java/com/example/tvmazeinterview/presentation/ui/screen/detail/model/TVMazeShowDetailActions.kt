package com.example.tvmazeinterview.presentation.ui.screen.detail.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.navigation.TVMazeDestinations
import com.example.tvmazeinterview.presentation.ui.navigation.destination.navigate
import com.example.tvmazeinterview.presentation.ui.viewmodel.home.TVMazeShowHomeViewModel
import com.example.tvmazeinterview.presentation.ui.viewmodel.show.detail.TVMazeShowDetailViewModel


data class TVMazeShowDetailActions(
    val onTabSelected: (Int) -> Unit,
    val onTVEpisodeSelected: (TVEpisode) -> Unit,
    val onRetry: () -> Unit
)

@Composable
fun rememberTVMazeShowDetailActions(
    id: Int,
    navController: NavController,
    viewModel: TVMazeShowDetailViewModel
) : TVMazeShowDetailActions{
    return remember {
        TVMazeShowDetailActions(
            onTabSelected = { tab ->
                viewModel.setTab(tab)
            },
            onTVEpisodeSelected = {
                navController.navigate(TVMazeDestinations.TVEpisodeDetail, mapOf("id" to it.id.toString()))
            },
            onRetry = {
                viewModel.getTvShowDetail(id)
            }
        )
    }
}