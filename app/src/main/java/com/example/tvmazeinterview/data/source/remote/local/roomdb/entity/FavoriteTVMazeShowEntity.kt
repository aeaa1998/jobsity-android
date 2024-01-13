package com.example.tvmazeinterview.data.source.remote.local.roomdb.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = FavoriteTVMazeShowEntity.TABLE_NAME)
data class FavoriteTVMazeShowEntity(
    @PrimaryKey()
    @ColumnInfo(name = "tv_show_id")
    val tvShowId: Int,
) {
    companion object {
        const val TABLE_NAME = "favorites"
    }
}
