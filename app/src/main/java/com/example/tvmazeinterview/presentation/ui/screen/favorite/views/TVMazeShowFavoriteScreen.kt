package com.example.tvmazeinterview.presentation.ui.screen.favorite.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.presentation.state.core.AppBarStateLaunchedEffect
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.screen.favorite.models.rememberTVMazeShowFavoriteActions
import com.example.tvmazeinterview.presentation.ui.viewmodel.favorite.TVMazeShowFavoriteViewModel


@Composable
fun TVMazeShowFavoriteScreen(
    navController: NavController,
    viewModel: TVMazeShowFavoriteViewModel = hiltViewModel()
) {
    AppBarStateLaunchedEffect {
        setTitle(UIText.Resource(R.string.favorites))
    }

    val actions = rememberTVMazeShowFavoriteActions(viewModel, navController)
    val favorites = viewModel.favorites.collectAsState()


    TVMazeShowFavoriteContent(shows = favorites.value.sortedBy { it.name }, actions = actions)
}