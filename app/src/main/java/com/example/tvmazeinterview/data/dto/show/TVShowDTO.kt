package com.example.tvmazeinterview.data.dto.show

import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.TVMazeShowEntity
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.example.tvmazeinterview.domain.traits.interfaces.ToEntity
import com.google.gson.annotations.SerializedName
import java.time.format.DateTimeFormatter


/**
 * DTO class to represent a TVShow
 */
data class TVShowDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("schedule")
    val schedule: TVShowScheduleDTO,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("image")
    val image: Map<String, String?>?,
    @SerializedName("rating")
    val rating: Map<String, Double?>?,
    @SerializedName("premiered")
    val premiered: String?,

) : ToEntity<TVShow> {
    override fun toEntity(): TVShow {

        return TVShow(
            id = id,
            name = name,
            poster = image?.firstNotNullOfOrNull { it.value },
            schedule = schedule.toEntity(),
            genres = genres,
            summary = summary,
            premiered = premiered,
            rating = rating?.firstNotNullOfOrNull { it.value }
        )
    }

    fun toRoomEntity() : TVMazeShowEntity {
        return TVMazeShowEntity(
            id = id,
            name = name,
            poster = image?.firstNotNullOf { it.value },
            schedule = schedule.toEntity(),
            genres = genres,
            summary = summary,
            premiered = premiered,
            rating = rating?.firstNotNullOfOrNull { it.value },
        )
    }
}
