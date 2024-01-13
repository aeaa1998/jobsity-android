package com.example.tvmazeinterview.domain.model.show

import com.example.tvmazeinterview.domain.traits.interfaces.Rateable
import com.example.tvmazeinterview.domain.traits.interfaces.Summarizes

data class TVShow(
    val id: Int,
    val name: String,
    //The url of the image
    val poster: String?,
    val schedule: TVShowSchedule,
    val genres: List<String>,
    override val summary: String?,
    val premiered: String?,
    override val rating: Double? = null,
) : Rateable, Summarizes