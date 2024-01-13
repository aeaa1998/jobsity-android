package com.example.tvmazeinterview.data.dto.episode

import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.domain.traits.interfaces.ToEntity
import com.google.gson.annotations.SerializedName


/**
 * DTO class to represent a TVEpisodeDetail
 */
data class TVEpisodeDetailDTO(
    val id: Int,
    val name: String,
    val number: Int,
    val season: Int,
    val summary: String?,
    val image: Map<String, String>,
    val runtime: Int,
    val rating: HashMap<String, Double?>? = null,
    @SerializedName("air_date")
    val airDate: String? = null
) : ToEntity<TVEpisodeDetail> {
    override fun toEntity(): TVEpisodeDetail {
        return TVEpisodeDetail(
            id = id,
            name = name,
            number = number,
            season = season,
            summary = summary,
            image = image.firstNotNullOf { it.value },
            runtime = runtime,
            rating = rating?.firstNotNullOfOrNull { it.value },
            airDate = airDate
        )
    }
}

