package com.example.tvmazeinterview.domain.model.episode

import com.example.tvmazeinterview.domain.traits.interfaces.Rateable
import com.example.tvmazeinterview.domain.traits.interfaces.Summarizes

data class TVEpisodeDetail(
    val id: Int,
    val name: String,
    val number: Int,
    val season: Int,
    override val summary: String?,
    val image: String?,
    val runtime: Int,
    override val rating: Double? = null,
    val airDate: String? = null
) : Rateable, Summarizes
