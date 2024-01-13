package com.example.tvmazeinterview.presentation.ui.component.entity.episode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail

@Composable
fun TVMazeEpisodeDetailImage(
    tvEpisodeDetail: TVEpisodeDetail,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    val colors = MaterialTheme.colorScheme
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(tvEpisodeDetail.image)
            .crossfade(true)
            .build(),
        contentDescription = "TV ${tvEpisodeDetail.name} image",
        modifier = modifier,
        contentScale = contentScale
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.weight(1f))
                CircularProgressIndicator(
                    color = colors.onTertiaryContainer,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

        } else {
            SubcomposeAsyncImageContent()
        }
    }
}