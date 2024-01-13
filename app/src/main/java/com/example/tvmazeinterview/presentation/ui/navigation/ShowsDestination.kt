package com.example.tvmazeinterview.presentation.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.tvmazeinterview.presentation.ui.navigation.destination.NavDestination


object TVMazeDestinations {
    val ShowsDestination = NavDestination(
            route = "shows",
    )

    val TVShowDetailDestination = NavDestination(
        route = "shows/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    )

    val TVEpisodeDetail = NavDestination(
        route = "episodes/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType })
    )


    val InitialDestinations: List<NavDestination>
        get() = listOf(ShowsDestination)

}


