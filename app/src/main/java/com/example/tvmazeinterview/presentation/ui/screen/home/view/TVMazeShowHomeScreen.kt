package com.example.tvmazeinterview.presentation.ui.screen.home.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.presentation.state.core.AppBarAction
import com.example.tvmazeinterview.presentation.state.core.AppBarStateLaunchedEffect
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.screen.home.model.rememberTVMazeShowHomeActions
import com.example.tvmazeinterview.presentation.ui.viewmodel.home.TVMazeShowHomeViewModel

@Composable
fun TVMazeShowHomeScreen(
    navController: NavController,
    viewModel: TVMazeShowHomeViewModel = hiltViewModel(),
){
    val items = viewModel.tvShows.collectAsLazyPagingItems()
    val actions = rememberTVMazeShowHomeActions(items, viewModel = viewModel, navController)
    val query = viewModel.query.collectAsState()


    AppBarStateLaunchedEffect {
        setTitle(UIText.Resource(R.string.app_name))
        addAction(
            AppBarAction(
                icon = Icons.Filled.Favorite,
                action = actions.onNavigateToFavorites
            )
        )
    }

    TVMazeShowHomeContent(
        items,
        actions = actions,
        query = query.value
    )
}