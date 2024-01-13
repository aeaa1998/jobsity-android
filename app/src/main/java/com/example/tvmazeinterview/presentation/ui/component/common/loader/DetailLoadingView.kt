package com.example.tvmazeinterview.presentation.ui.component.common.loader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.presentation.ui.component.core.Height
import com.example.tvmazeinterview.presentation.ui.component.core.Weight
import com.example.tvmazeinterview.presentation.ui.component.core.Width
import com.example.tvmazeinterview.presentation.ui.theme.paddings
import com.example.tvmazeinterview.presentation.utilities.extensions.shimmerLoadingAnimation

@Composable
fun DetailLoadingView(){
    Column(
        Modifier
            .fillMaxSize()
            .padding(MaterialTheme.paddings.large)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier

                .height(140.dp)
                .width(80.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.DarkGray)
                .shimmerLoadingAnimation()
            )
            Width(width = 26.dp)
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for (i in 1..3){
                    Box(modifier = Modifier
                        .height(10.dp)
                        .width(120.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(Color.DarkGray)
                        .shimmerLoadingAnimation()
                    )
                }
            }
        }

        Height(height = 16.dp)

        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(Color.DarkGray)
                .fillMaxWidth()
                .height(60.dp)
                .shimmerLoadingAnimation()
        )

        Height(height = 16.dp)

        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .background(Color.DarkGray)
                .fillMaxWidth()
                .fillMaxHeight()
                .shimmerLoadingAnimation()
        )
    }
}

@Preview
@Composable
private fun Preview() {
    DetailLoadingView()
}