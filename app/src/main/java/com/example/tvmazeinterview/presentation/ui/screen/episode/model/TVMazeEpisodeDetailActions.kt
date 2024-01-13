package com.example.tvmazeinterview.presentation.ui.screen.episode.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.tvmazeinterview.presentation.ui.navigation.TVMazeDestinations
import com.example.tvmazeinterview.presentation.ui.navigation.destination.navigate
import com.example.tvmazeinterview.presentation.ui.screen.detail.model.TVMazeShowDetailActions
import com.example.tvmazeinterview.presentation.ui.viewmodel.episode.TVMazeEpisodeDetailViewModel
import com.example.tvmazeinterview.presentation.ui.viewmodel.show.detail.TVMazeShowDetailViewModel

data class TVMazeEpisodeDetailActions(
    val onRetry: () -> Unit
)

@Composable
fun rememberTVMazeEpisodeDetailActions(
    viewModel: TVMazeEpisodeDetailViewModel
) : TVMazeEpisodeDetailActions {
    return remember {
        TVMazeEpisodeDetailActions(
            onRetry = {

            }
        )
    }
}