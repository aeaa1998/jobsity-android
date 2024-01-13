package com.example.tvmazeinterview.presentation.ui.screen.detail.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.presentation.state.core.AppBarStateLaunchedEffect
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.screen.detail.model.rememberTVMazeShowDetailActions
import com.example.tvmazeinterview.presentation.ui.viewmodel.home.TVMazeShowHomeViewModel
import com.example.tvmazeinterview.presentation.ui.viewmodel.show.detail.TVMazeShowDetailViewModel


/**
 * The screen for the detail of the tv show
 * @param id [Int] The id of the show
 */
@Composable
fun TVMazeShowDetailScreen(
    id: Int,
    navController: NavController,
    viewModel: TVMazeShowDetailViewModel = hiltViewModel()
){
    LaunchedEffect(Unit){
        viewModel.getTvShowDetail(id)
    }

    val state = viewModel.state.value
    val actions = rememberTVMazeShowDetailActions(
        id = id,
        navController = navController,
        viewModel = viewModel
    )

    TVMazeShowDetailContent(state, selectedIndex = viewModel.tab.value, actions = actions)
}