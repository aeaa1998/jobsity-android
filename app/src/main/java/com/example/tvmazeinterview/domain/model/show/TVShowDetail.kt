package com.example.tvmazeinterview.domain.model.show

import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.season.TVSeason

data class TVShowDetail(
    val show: TVShow,
    val seasons: List<TVSeason>
)