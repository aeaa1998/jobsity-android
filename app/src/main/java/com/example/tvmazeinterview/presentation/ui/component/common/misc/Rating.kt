package com.example.tvmazeinterview.presentation.ui.component.common.misc

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.traits.interfaces.Rateable

@Composable
fun Rating(rateable: Rateable){
    val colors = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.rating),
            style = typography.labelMedium,
            color = colors.onSecondaryContainer
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Rating star",
            tint = Color.Yellow,
            modifier = Modifier.size(14.dp)
        )

        Text(
            text = rateable.rating?.toString() ?: stringResource(id = R.string.not_available),
            style = typography.labelMedium,
            color = colors.onSecondaryContainer
        )

    }
}