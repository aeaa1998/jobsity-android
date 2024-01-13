package com.example.tvmazeinterview.domain.model.show

import androidx.compose.runtime.mutableStateOf
import com.example.tvmazeinterview.domain.traits.interfaces.Rateable
import com.example.tvmazeinterview.domain.traits.interfaces.Summarizes
import kotlinx.coroutines.flow.MutableStateFlow

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
    val isFavorite: MutableStateFlow<Boolean> = MutableStateFlow(false)
) : Rateable, Summarizes