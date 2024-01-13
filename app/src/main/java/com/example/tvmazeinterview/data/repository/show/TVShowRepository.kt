package com.example.tvmazeinterview.data.repository.show

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tvmazeinterview.data.misc.TVDataModuleConstants
import com.example.tvmazeinterview.data.source.paging.show.TVShowPagingSource
import com.example.tvmazeinterview.data.source.remote.api.show.TVShowApi
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.FavoriteTVMazeShowDao
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.TVMazeShowEntityDao
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.FavoriteTVMazeShowEntity
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.TVMazeShowEntity
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.repository.ITVShowRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TVShowRepository @Inject constructor(
    private val tvShowApi: TVShowApi,
    private val tvMazeShowEntityDao: TVMazeShowEntityDao,
    private val favoriteTVMazeShowDao: FavoriteTVMazeShowDao
) : ITVShowRepository {
    override fun searchShows(): Flow<PagingData<TVShow>> {
        return Pager(
            config = PagingConfig(pageSize = TVDataModuleConstants.MAX_PAGE_SIZE, prefetchDistance = 3),
            pagingSourceFactory = {
                TVShowPagingSource(tvShowApi, tvMazeShowEntityDao)
            }
        ).flow
    }

    override suspend fun showById(id: Int): TVShow {
        return tvShowApi.show(id).toEntity()
    }

    override suspend fun getFavorites(): List<TVShow> {
        val favorites = favoriteTVMazeShowDao.getFavorites()
        val tvsCached = tvMazeShowEntityDao.findByIds(favorites.map { it.tvShowId })
        return tvsCached.map { it.toEntity() }.map {
            it.isFavorite.value = true
            it
        }
    }

    override suspend fun getFavoritesById(id: Int): TVShow {

        val entity = favoriteTVMazeShowDao.getFavoritesById(id)
        return tvMazeShowEntityDao.findById(entity.tvShowId).toEntity()
    }

    override suspend fun toggleFavorite(tvShow: TVShow, favorite: Boolean) {
        if (favorite){
            favoriteTVMazeShowDao.insertFavorites(FavoriteTVMazeShowEntity(tvShow.id))
        }else{
            favoriteTVMazeShowDao.deleteFavorite(tvShow.id)
        }

    }

}