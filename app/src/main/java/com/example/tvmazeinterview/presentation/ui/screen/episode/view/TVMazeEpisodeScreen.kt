package com.example.tvmazeinterview.presentation.ui.screen.episode.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.presentation.state.core.AppBarStateLaunchedEffect
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.screen.episode.model.rememberTVMazeEpisodeDetailActions
import com.example.tvmazeinterview.presentation.ui.viewmodel.episode.TVMazeEpisodeDetailViewModel

@Composable
fun TVMazeEpisodeScreen(
    id: Int,
    viewModel: TVMazeEpisodeDetailViewModel = hiltViewModel()
) {
    val actions = rememberTVMazeEpisodeDetailActions(viewModel = viewModel)
    val state = viewModel.episodeDetailState.value

    LaunchedEffect(Unit){
        viewModel.getEpisodeDetail(id)
    }



    TVMazeEpisodeContent(state, actions)

}