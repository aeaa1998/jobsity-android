package com.example.tvmazeinterview.domain.model.season

import com.example.tvmazeinterview.domain.model.episode.TVEpisode

data class TVSeason(
    val number: Int,
    val episodes: List<TVEpisode>
)