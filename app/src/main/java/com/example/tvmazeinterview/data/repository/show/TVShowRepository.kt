package com.example.tvmazeinterview.data.repository.show

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tvmazeinterview.data.misc.TVDataModuleConstants
import com.example.tvmazeinterview.data.source.paging.show.TVShowPagingSource
import com.example.tvmazeinterview.data.source.remote.api.show.TVShowApi
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.repository.ITVShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class TVShowRepository @Inject constructor(
    private val tvShowApi: TVShowApi
) : ITVShowRepository {
    override fun searchShows(): Flow<PagingData<TVShow>> {
        return Pager(
            config = PagingConfig(pageSize = TVDataModuleConstants.MAX_PAGE_SIZE, prefetchDistance = 3),
            pagingSourceFactory = {
                TVShowPagingSource(tvShowApi)
            }
        ).flow
    }

//    override suspend fun searchShows(query: String, page: Int): List<TVShow> = tvShowApi.getShows(query = query, page = page).map { it.toEntity() }

    override suspend fun showById(id: Int): TVShow {
        return tvShowApi.show(id).toEntity()
    }

}