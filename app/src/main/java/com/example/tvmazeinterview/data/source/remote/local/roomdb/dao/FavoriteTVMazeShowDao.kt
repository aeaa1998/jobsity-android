package com.example.tvmazeinterview.data.source.remote.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.FavoriteTVMazeShowEntity
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.FavoriteWithTVShow
import com.example.tvmazeinterview.domain.model.show.TVShow

/**
 * The dao to represent each one of the entries for the favorites
 */
@Dao
interface FavoriteTVMazeShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorites(favorite: FavoriteTVMazeShowEntity)

    @Query("SELECT * FROM ${FavoriteTVMazeShowEntity.TABLE_NAME}")
    suspend fun getFavorites(): List<FavoriteTVMazeShowEntity>

    @Query("SELECT * FROM ${FavoriteTVMazeShowEntity.TABLE_NAME} WHERE tv_show_id = :id")
    suspend fun getFavoritesById(id: Int): FavoriteTVMazeShowEntity

    @Query("DELETE FROM ${FavoriteTVMazeShowEntity.TABLE_NAME}")
    suspend fun deleteAll()

    @Query("DELETE FROM ${FavoriteTVMazeShowEntity.TABLE_NAME} WHERE tv_show_id = :id")
    suspend fun deleteFavorite(id: Int)
}