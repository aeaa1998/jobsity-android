package com.example.tvmazeinterview.presentation.ui.navigation.destination

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.composable(destination: NavDestination, content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit){
    composable(
        destination.route,
        destination.arguments,
        content = content
    )
}

/**
 * Help smooth the navigation with just using the destination instance
 * @param destination [NavDestination] The destination to nav into
 * @param builder [NavOptionsBuilder.() -> Unit] Callback to add builder options into the navigation
 */
fun NavController.navigate(destination: NavDestination, builder: NavOptionsBuilder.() -> Unit = {}) {
    navigate(destination.route, builder)
}


/**
 * Help smooth the navigation with just using the destination instance
 * @param destination [NavDestination] The destination to nav into
 * @param params [Map<String, String>] The params to navigate
 */
fun NavController.navigate(destination: NavDestination, params: Map<String, String>) {
    var finalRouter = destination.route
    params.forEach { (key, value) ->
        finalRouter = finalRouter.replace("{$key}", value)
    }

    navigate(finalRouter)
}