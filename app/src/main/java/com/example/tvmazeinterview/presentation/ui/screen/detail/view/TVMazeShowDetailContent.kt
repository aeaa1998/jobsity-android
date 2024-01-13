package com.example.tvmazeinterview.presentation.ui.screen.detail.view

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.domain.model.misc.WeekDay
import com.example.tvmazeinterview.domain.model.season.TVSeason
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowDetail
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.example.tvmazeinterview.presentation.state.core.AppBarStateLaunchedEffect
import com.example.tvmazeinterview.presentation.state.core.UIText
import com.example.tvmazeinterview.presentation.ui.component.common.error.ScreenError
import com.example.tvmazeinterview.presentation.ui.component.common.loader.DetailLoadingView
import com.example.tvmazeinterview.presentation.ui.component.core.Height
import com.example.tvmazeinterview.presentation.ui.component.entity.episode.TVMazeEpisodeRow
import com.example.tvmazeinterview.presentation.ui.screen.detail.model.TVMazeShowDetailActions
import com.example.tvmazeinterview.presentation.ui.screen.detail.model.TVMazeShowDetailTab
import com.example.tvmazeinterview.presentation.ui.theme.paddings




@Composable
fun TVMazeShowDetailContent(
    tvShowDetailState: ResponseState<TVShowDetail>,
    selectedIndex: Int,
    actions: TVMazeShowDetailActions
){
    when(tvShowDetailState) {
        is ResponseState.Success -> {
            val tvShowDetail = tvShowDetailState.response
            val verticalScrollState = rememberScrollState()
            val tvShow = tvShowDetail.show
            val selectedTab = remember(selectedIndex) {
                TVMazeShowDetailTab.values().get(selectedIndex)
            }
            val seasons = tvShowDetail.seasons
            //Handle the app bar title
            AppBarStateLaunchedEffect {
                setTitle(UIText.Raw(tvShowDetail.show.name))
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .verticalScroll(verticalScrollState),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TVMazeShowDetailHeader(tvShow = tvShow, actions.onFavorite)

                TVMazeShowDetailTabs(selectedIndex, actions.onTabSelected)

                Crossfade(
                    targetState = selectedTab,
                    label = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(MaterialTheme.paddings.medium)
                ) { selectedTab ->
                    when(selectedTab) {
                        TVMazeShowDetailTab.Information -> TVMazeShowDetailInformation(tvShow)

                        TVMazeShowDetailTab.Episodes -> TVMazeShowDetailSeasons(seasons = seasons, onEpisodeClick = actions.onTVEpisodeSelected)


                    }
                }
            }
        }

        is ResponseState.Loading -> DetailLoadingView()

        is ResponseState.Failed -> ScreenError(onRetry = actions.onRetry)
    }
}

@Composable
fun TVMazeEpisodeImage(
    image: String,
    modifier: Modifier = Modifier
){
    val colors = MaterialTheme.colorScheme
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentDescription = "TV episode image",
        modifier = Modifier
            .then(modifier),
        contentScale = ContentScale.Fit
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.weight(1f))
                CircularProgressIndicator(
                    color = colors.onTertiaryContainer,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

        } else {
            SubcomposeAsyncImageContent()
        }
    }
}


@Preview
@Composable
fun TVMazeShowDetailContentPreview(){
    TVMazeShowDetailContent(
        ResponseState.Success(TVShowDetail(
            show = TVShow(
                id = 1,
                name ="Nombre del show",
                poster = "https://static.tvmaze.com/uploads/images/medium_landscape/1/4388.jpg",
                schedule = TVShowSchedule("22:00", days = listOf(WeekDay.Monday, WeekDay.Friday)),
                genres = listOf("Drama", "Romance"),
//                summary = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>",
                summary = null,
                premiered = "2001-03-10"
            ),
            seasons = List(3) { season ->
                TVSeason(
                    number= season,
                    episodes = List(8) {
                        TVEpisode(
                            id = 1,
                            name = "Episode",
                            number = it,
                            season = season,
                            summary = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>",
                            image = "https://static.tvmaze.com/uploads/images/medium_portrait/31/78286.jpg",
                            runtime = 65
                        )
                    }
                )
            }
        )),
        1,
        TVMazeShowDetailActions({}, {}, {}, {})
    )
}