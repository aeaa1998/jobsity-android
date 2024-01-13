package com.example.tvmazeinterview.domain.repository

import androidx.paging.PagingData
import com.example.tvmazeinterview.domain.model.show.TVShow
import kotlinx.coroutines.flow.Flow


interface ITVShowRepository {

    fun searchShows() : Flow<PagingData<TVShow>>

    suspend fun showById(id: Int) : TVShow

    suspend fun getFavorites() : List<TVShow>

//    suspend fun getFavoritesByIds(ids: List<Int>) : List<TVShow>

    suspend fun getFavoritesById(id: Int) : TVShow

    suspend fun toggleFavorite(tvShow: TVShow, favorite: Boolean)
}