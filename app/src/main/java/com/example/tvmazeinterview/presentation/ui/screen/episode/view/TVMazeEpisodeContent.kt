package com.example.tvmazeinterview.presentation.ui.screen.episode.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.presentation.state.core.AppBarStateLaunchedEffect
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.component.common.error.ScreenError
import com.example.tvmazeinterview.presentation.ui.component.common.loader.DetailLoadingView
import com.example.tvmazeinterview.presentation.ui.screen.episode.model.TVMazeEpisodeDetailActions
import com.example.tvmazeinterview.presentation.utilities.extensions.Random

@Composable
fun TVMazeEpisodeContent(
    tvEpisodeDetailState: ResponseState<TVEpisodeDetail>,
    actions: TVMazeEpisodeDetailActions
){

    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.secondaryContainer)){
        when(tvEpisodeDetailState) {
            is ResponseState.Success -> TVMazeEpisodeSuccessContent(tvEpisodeDetailState.response)
            is ResponseState.Failed -> ScreenError(onRetry = actions.onRetry)
            is ResponseState.Loading -> DetailLoadingView()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TVMazeEpisodeContentPreview(){
    TVMazeEpisodeContent(
        ResponseState.Success(Random.TVEpisodeDetailRandom(summary = null)),
        TVMazeEpisodeDetailActions({})
    )
}