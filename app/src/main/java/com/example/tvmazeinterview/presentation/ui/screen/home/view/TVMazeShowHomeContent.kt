package com.example.tvmazeinterview.presentation.ui.screen.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.misc.WeekDay
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.example.tvmazeinterview.presentation.ui.screen.home.model.TVMazeShowHomeActions
import com.example.tvmazeinterview.presentation.ui.theme.paddings
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun TVMazeShowHomeContent(
    shows: LazyPagingItems<TVShow>,
    query: String,
    actions: TVMazeShowHomeActions,
){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.paddings.medium)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = actions.onQueryChange,
            leadingIcon = {
                Icon(imageVector = Icons.Rounded.Search, contentDescription = "Search icon")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(id = R.string.search_shows))
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        when (shows.loadState.refresh) {
            is LoadState.Loading -> {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                }
            }

            is LoadState.Error -> {
                Column(Modifier.padding(MaterialTheme.paddings.medium), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = stringResource(id = R.string.error_loading_message))
                    Button(onClick = {
                        actions.onRetry()
                    }) {
                        Text(text = stringResource(id = R.string.retry))
                    }
                }
            }

            else -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),

                ){
                    items(shows.itemCount){ index ->
                        shows[index]?.let { show ->
                            TVMazeShowCardView(tvShow = show, onTVShowClicked = actions.onTVShowClicked)
                        }
                    }

                    item {
                        when (shows.loadState.append) {
                            is LoadState.Loading -> {
                                Row(Modifier.padding(MaterialTheme.paddings.medium), verticalAlignment = Alignment.CenterVertically) {
                                    Text(text = stringResource(id = R.string.loading))
                                    Spacer(modifier = Modifier.width(8.dp))
                                    CircularProgressIndicator(Modifier.size(18.dp))
                                }
                            }

                            is LoadState.Error -> {
                                Column(Modifier.padding(MaterialTheme.paddings.medium), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Text(text = stringResource(id = R.string.error_loading_message))
                                    Button(onClick = {
                                        actions.onRetry()
                                    }) {
                                        Text(text = stringResource(id = R.string.retry))
                                    }
                                }
                            }

                            else -> {}
                        }
                    }
                }
            }
        }

    }

}

@Preview
@Composable
private fun TVMazeShowHomeContentPreview(){
    val data = remember {
        MutableStateFlow(PagingData.from(listOf(TVShow(
            id = 1,
            name ="Nombre del show",
            poster = "https://static.tvmaze.com/uploads/images/medium_landscape/1/4388.jpg",
            schedule = TVShowSchedule("22:00", days = listOf(WeekDay.Monday, WeekDay.Friday)),
            genres = listOf("Drama", "Romance"),
            summary = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>",
            premiered = "2020-1-1"
        ))))

    }

    val items = data.collectAsLazyPagingItems()

    TVMazeShowHomeContent(
        items,
        "",
        TVMazeShowHomeActions({}, {}, {})
    )
}