package com.example.tvmazeinterview.presentation.ui.screen.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tvmazeinterview.domain.model.misc.WeekDay
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.example.tvmazeinterview.presentation.ui.component.entity.tvshow.TVMazeShowGenres
import com.example.tvmazeinterview.presentation.ui.component.entity.tvshow.TVMazeShowImage
import com.example.tvmazeinterview.presentation.ui.component.entity.tvshow.TVMazeShowPremieredText
import com.example.tvmazeinterview.presentation.ui.component.common.misc.Rating
import com.example.tvmazeinterview.presentation.ui.component.core.Weight
import com.example.tvmazeinterview.presentation.ui.theme.paddings


@Composable
fun TVMazeShowCardView(
    tvShow: TVShow,
    onTVShowClicked: (TVShow) -> Unit = {},
    onTVShowFavorite: (TVShow) -> Unit = {}
) {
    val colors = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography
    val context = LocalContext.current
    val paddings = MaterialTheme.paddings
    val isFavorite = tvShow.isFavorite.collectAsState()


    Row(
        modifier = Modifier
            .background(colors.secondaryContainer)
            .clip(MaterialTheme.shapes.extraSmall)
            .fillMaxWidth()
            .clickable { onTVShowClicked(tvShow) },
        verticalAlignment = Alignment.CenterVertically
    ) {

        TVMazeShowImage(tvShow, modifier = Modifier
            .clip(MaterialTheme.shapes.extraSmall)
            .width(80.dp)
            .height(100.dp))
        Column(
            Modifier
                .padding(paddings.medium)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Column {
                Row {
                    Text(
                        text = tvShow.name,
                        style = typography.titleSmall,
                        color = colors.onSecondaryContainer
                    )
                    Weight()
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Is favorite",
                        modifier = Modifier.clickable {
                            onTVShowFavorite(tvShow)
                        },
                        tint = if (isFavorite.value) Color.Red else Color.Black
                    )
                }

                TVMazeShowPremieredText(tvShow)
            }


            Rating(tvShow)

            TVMazeShowGenres(tvShow)
        }
    }

}


@Preview
@Composable
fun TVMazeShowCardViewPreview(){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item {
            TVMazeShowCardView(
                TVShow(
                    id = 1,
                    name ="Nombre del show",
                    poster = "https://static.tvmaze.com/uploads/images/medium_landscape/1/4388.jpg",
                    schedule = TVShowSchedule("22:00", days = listOf(WeekDay.Monday, WeekDay.Friday)),
                    genres = listOf("Drama", "Romance"),
                    summary = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>",
                    premiered = "2001-03-10"
                )
            )
        }
        item {
            TVMazeShowCardView(
                TVShow(
                    id = 1,
                    name ="Nombre del show",
                    poster = "https://static.tvmaze.com/uploads/images/medium_landscape/1/4388.jpg",
                    schedule = TVShowSchedule("22:00", days = listOf(WeekDay.Monday, WeekDay.Friday)),
                    genres = listOf("Drama", "Romance"),
                    summary = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>",
                    premiered = "2001-03-10"
                )
            )
        }
    }


}