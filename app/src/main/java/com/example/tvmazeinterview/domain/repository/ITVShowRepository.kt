package com.example.tvmazeinterview.domain.repository

import androidx.paging.PagingData
import com.example.tvmazeinterview.domain.model.show.TVShow
import kotlinx.coroutines.flow.Flow


interface ITVShowRepository {

    /**
     * Returns the pagination for the shows
     */
    fun searchShows() : Flow<PagingData<TVShow>>

    /**
     * Returns a single show
     */

    suspend fun showById(id: Int) : TVShow

    /**
     * Returns the favorites
     */
    suspend fun getFavorites() : List<TVShow>


    /**
     * Returns a single instance of a favorite
     */
    suspend fun getFavoritesById(id: Int) : TVShow


    /**
     * Toggle the favorite status
     */
    suspend fun toggleFavorite(tvShow: TVShow, favorite: Boolean)
}