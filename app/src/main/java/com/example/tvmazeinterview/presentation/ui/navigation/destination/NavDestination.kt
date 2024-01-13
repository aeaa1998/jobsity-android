package com.example.tvmazeinterview.presentation.ui.navigation.destination

import androidx.navigation.NamedNavArgument


open class NavDestination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
)