package com.example.tvmazeinterview.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.presentation.composition.LocalAppBarState
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.state.core.rememberAppBarState
import com.example.tvmazeinterview.presentation.ui.component.core.View
import com.example.tvmazeinterview.presentation.ui.navigation.TVMazeDestinations
import com.example.tvmazeinterview.presentation.ui.navigation.TVMazeShowsNavHost
import com.example.tvmazeinterview.presentation.ui.theme.TVMazeInterviewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TVMazeInterviewTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val appBarState = rememberAppBarState(
                    title = UIText.Resource(R.string.app_name),
                    actions = listOf()
                )

                val navStackEntry = navController.currentBackStackEntryAsState()


                CompositionLocalProvider(LocalAppBarState provides appBarState) {
                    Scaffold(
                        topBar = {
                            appBarState.View(navController, TVMazeDestinations.InitialDestinations)
                        }
                    ) { paddingValues ->

                        TVMazeShowsNavHost(navController, paddingValues)
                    }
                }

            }
        }
    }
}
