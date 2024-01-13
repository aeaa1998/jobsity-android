package com.example.tvmazeinterview.data.source.remote.local.roomdb.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.example.tvmazeinterview.domain.traits.interfaces.ToEntity

@Entity(tableName = TVMazeShowEntity.TABLE_NAME)
data class TVMazeShowEntity(
    @PrimaryKey val id: Int,
    val name: String,
    //The url of the image
    val poster: String?,

    val schedule: TVShowSchedule,
    val genres: List<String>,
    val summary: String?,
    val premiered: String?,
    val rating: Double? = null,
) : ToEntity<TVShow> {
    override fun toEntity(): TVShow {
        return TVShow(
            id = id,
            name = name,
            poster = poster,
            schedule = schedule,
            genres = genres,
            summary = summary,
            premiered = premiered,
            rating = rating
        )
    }

    companion object {
        const val TABLE_NAME = "tv_shows"
    }
}