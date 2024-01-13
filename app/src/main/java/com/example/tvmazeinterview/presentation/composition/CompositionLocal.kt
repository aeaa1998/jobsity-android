package com.example.tvmazeinterview.presentation.composition

import androidx.compose.runtime.compositionLocalOf
import com.example.tvmazeinterview.presentation.state.core.AppBarState

val LocalAppBarState = compositionLocalOf { AppBarState() }