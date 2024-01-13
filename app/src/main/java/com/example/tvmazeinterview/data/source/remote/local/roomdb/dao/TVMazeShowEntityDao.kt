package com.example.tvmazeinterview.data.source.remote.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.FavoriteTVMazeShowEntity
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.TVMazeShowEntity
import com.example.tvmazeinterview.domain.model.show.TVShow

@Dao
interface TVMazeShowEntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShows: List<TVMazeShowEntity>)


    @Query("SELECT * FROM ${TVMazeShowEntity.TABLE_NAME} WHERE id IN (:ids)")
    suspend fun findByIds(ids: List<Int>): List<TVMazeShowEntity>

    @Query("SELECT * FROM ${TVMazeShowEntity.TABLE_NAME} WHERE id = :id")
    suspend fun findById(id: Int): TVMazeShowEntity

}