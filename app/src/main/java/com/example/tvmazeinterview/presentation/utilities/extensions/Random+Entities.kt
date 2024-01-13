package com.example.tvmazeinterview.presentation.utilities.extensions

import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
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
}

