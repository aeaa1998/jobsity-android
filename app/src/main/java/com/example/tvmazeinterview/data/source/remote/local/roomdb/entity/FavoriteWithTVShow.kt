package com.example.tvmazeinterview.data.source.remote.local.roomdb.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.example.tvmazeinterview.domain.model.misc.WeekDay
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.example.tvmazeinterview.domain.traits.interfaces.ToEntity

data class FavoriteWithTVShow(
    @Embedded
    val favoriteWithTVShow: FavoriteTVMazeShowEntity,
    @Relation(parentColumn = "id", entityColumn = "tv_show_id", entity = TVMazeShowEntity::class)
    val tvShow: TVMazeShowEntity,
) : ToEntity<TVShow>{
    override fun toEntity(): TVShow {
        return tvShow.toEntity()
    }
}
