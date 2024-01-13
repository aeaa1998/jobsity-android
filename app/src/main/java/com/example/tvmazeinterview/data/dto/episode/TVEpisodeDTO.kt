package com.example.tvmazeinterview.data.dto.episode

import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.traits.interfaces.ToEntity
import com.google.gson.annotations.SerializedName

/**
 * DTO class to represent a TVEpisode
 */
data class TVEpisodeDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("season")
    val season: Int,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("image")
    val image: Map<String, String?>?,
    @SerializedName("runtime")
    val runtime: Int,
) : ToEntity<TVEpisode>{
    override fun toEntity(): TVEpisode {
        return TVEpisode(
            id = id,
            name = name,
            number = number,
            season = season,
            summary = summary,
            image = image?.firstNotNullOfOrNull { it?.value },
            runtime = runtime
        )
    }

}