package com.example.tvmazeinterview.domain.repository

import androidx.paging.PagingData
import com.example.tvmazeinterview.domain.model.show.TVShow
import kotlinx.coroutines.flow.Flow


interface ITVShowRepository {

    fun searchShows() : Flow<PagingData<TVShow>>
//    suspend fun searchShows(query: String, page: Int) : List<TVShow>

    suspend fun showById(id: Int) : TVShow
}