package com.example.tvmazeinterview.presentation.ui.screen.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.ui.component.entity.tvshow.TVMazeShowGenres
import com.example.tvmazeinterview.presentation.ui.component.entity.tvshow.TVMazeShowImage
import com.example.tvmazeinterview.presentation.ui.component.entity.tvshow.TVMazeShowPremieredText
import com.example.tvmazeinterview.presentation.ui.component.common.misc.Rating
import com.example.tvmazeinterview.presentation.ui.theme.paddings

@Composable
private fun TVMazeShowDetailHeaderTitle(tvShow: TVShow) {
    Text(
        text =  tvShow.name,
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onSecondaryContainer
    )
}

@Composable
private fun TVMazeShowDetailHeaderImage(tvShow: TVShow) {

    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = MaterialTheme.paddings.medium),
    ) {
        TVMazeShowImage(
            tvShow,
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraSmall)
                .padding(top = 25.dp)
                .background(Color.White)
                .width(120.dp)
                .height(160.dp)
        )
    }
}

@Composable
fun TVMazeShowDetailHeader(tvShow: TVShow){
    Box(
        Modifier
    ) {

        Column(Modifier) {
            //the top part should be later replaced with a preview
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(148.dp)
                .background(MaterialTheme.colorScheme.onTertiaryContainer)
            )
            Column(
                Modifier
                    .padding(MaterialTheme.paddings.medium)
                    .padding(top = 8.dp),
                horizontalAlignment = AbsoluteAlignment.Right
            ) {
                Rating(rateable = tvShow)
                Column(
                    modifier = Modifier.fillMaxWidth().padding(top = 14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TVMazeShowDetailHeaderTitle(tvShow)
                    TVMazeShowPremieredText(tvShow = tvShow)
                    TVMazeShowGenres(tvShow = tvShow)

                }
            }
        }

        TVMazeShowDetailHeaderImage(tvShow)
    }
}