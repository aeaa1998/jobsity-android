package com.example.tvmazeinterview.domain.model.episode

data class TVEpisode(
    val id: Int,
    val name: String,
    val number: Int,
    val season: Int,
    val summary: String?,
    val image: String?,
    val runtime: Int
)
