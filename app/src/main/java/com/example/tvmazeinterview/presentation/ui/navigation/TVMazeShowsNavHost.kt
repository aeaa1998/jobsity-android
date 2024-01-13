package com.example.tvmazeinterview.presentation.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.tvmazeinterview.presentation.ui.navigation.destination.composable
import com.example.tvmazeinterview.presentation.ui.screen.detail.view.TVMazeShowDetailScreen
import com.example.tvmazeinterview.presentation.ui.screen.episode.view.TVMazeEpisodeScreen
import com.example.tvmazeinterview.presentation.ui.screen.favorite.views.TVMazeShowFavoriteScreen
import com.example.tvmazeinterview.presentation.ui.screen.home.view.TVMazeShowHomeScreen

@Composable
fun TVMazeShowsNavHost(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    TVMazeDestinations.run {
        NavHost(
            navController = navController,
            startDestination = ShowsDestination.route,
            modifier = Modifier.padding(paddingValues)
        ){

            composable(ShowsDestination){
                TVMazeShowHomeScreen(navController)
            }

            composable(TVShowDetailDestination) { backStackEntry ->
                backStackEntry.arguments?.getInt("id")?.let { TVMazeShowDetailScreen(it, navController) }
            }

            composable(TVEpisodeDetail){ backStackEntry ->
                backStackEntry.arguments?.getInt("id")?.let { TVMazeEpisodeScreen(it) }
            }

            composable(TVShowFavorites){
                TVMazeShowFavoriteScreen(navController = navController)
            }
        }
    }
}