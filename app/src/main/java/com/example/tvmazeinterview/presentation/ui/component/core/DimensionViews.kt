package com.example.tvmazeinterview.presentation.ui.component.core

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp

@Composable
fun ColumnScope.Height(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun ColumnScope.Weight(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
fun RowScope.Width(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun RowScope.Weight(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}