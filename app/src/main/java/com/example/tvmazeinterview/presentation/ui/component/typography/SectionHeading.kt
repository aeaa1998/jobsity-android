package com.example.tvmazeinterview.presentation.ui.component.typography

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SectionHeading(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium
    )
}