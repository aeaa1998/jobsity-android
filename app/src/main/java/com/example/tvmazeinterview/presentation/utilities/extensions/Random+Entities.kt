package com.example.tvmazeinterview.presentation.utilities.extensions

import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.domain.model.misc.WeekDay
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import java.util.Random

object Random {
    fun TVEpisodeDetailRandom(
        summary: String? = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>"
    ) =
        TVEpisodeDetail(
            id = Random().nextInt(),
            name = "Random",
            number = Random().nextInt(),
            season = Random().nextInt(),
            summary = summary,
            image = "https://static.tvmaze.com/uploads/images/medium_landscape/35/89331.jpg",
            runtime = 60,
            rating = 4.5,
            airDate = "2011-10-27"
        )

    fun TVShowRandom(
        summary: String? = "<p>This Emmy winning series is a comic look at the assorted humiliations and rare triumphs of a group of girls in their 20s.</p>"
    ) =
        TVShow(
            id = 1,
            name ="Nombre del show",
            poster = "https://static.tvmaze.com/uploads/images/medium_landscape/1/4388.jpg",
            schedule = TVShowSchedule("22:00", days = listOf(WeekDay.Monday, WeekDay.Friday)),
            genres = listOf("Drama", "Romance"),
            summary = summary,
            premiered = "2001-03-10"
        )
}

