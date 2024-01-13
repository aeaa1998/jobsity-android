package com.example.tvmazeinterview.presentation.ui.component.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tvmazeinterview.presentation.state.core.AppBarState
import com.example.tvmazeinterview.presentation.ui.navigation.destination.NavDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarState.View(
    navController: NavController,
    homeDestinations: List<NavDestination>
){
    val navStackEntry = navController.currentBackStackEntryAsState()

    TopAppBar(
        title = {
            Text(text = title.value.text)
        },
        actions = {
            actions.forEach { action ->
                IconButton(onClick = action.action) {
                    Icon(imageVector = action.icon, contentDescription = "Action")
                }
            }
        },
        navigationIcon = {
            navStackEntry.value?.destination?.route?.let { route ->
                //Is not in the initial destinations we will not show it
                if(!homeDestinations.map { it.route }.contains(route)){
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Action")
                    }
                }
            }
        }
    )
}