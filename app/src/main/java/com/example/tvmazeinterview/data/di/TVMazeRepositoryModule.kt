package com.example.tvmazeinterview.data.di

import com.example.tvmazeinterview.data.repository.episode.TVEpisodeRepository
import com.example.tvmazeinterview.data.repository.show.TVShowRepository
import com.example.tvmazeinterview.data.source.remote.api.episode.TVEpisodeApi
import com.example.tvmazeinterview.data.source.remote.api.show.TVShowApi
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.FavoriteTVMazeShowDao
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.TVMazeShowEntityDao
import com.example.tvmazeinterview.domain.repository.ITVEpisodeRepository
import com.example.tvmazeinterview.domain.repository.ITVShowRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Singleton module containing all of the repositories
 */
@Module
@InstallIn(SingletonComponent::class)
class TVMazeRepositoryModule {

    @Provides
    @Singleton
    fun providesTVShowRepository(
        tvShowApi: TVShowApi,
        tvMazeShowEntityDao: TVMazeShowEntityDao,
        favoriteTVMazeShowDao: FavoriteTVMazeShowDao
    ) : ITVShowRepository = TVShowRepository(tvShowApi, tvMazeShowEntityDao, favoriteTVMazeShowDao)

    @Provides
    @Singleton
    fun providesTVEpisodeRepository(
        tvEpisodeApi: TVEpisodeApi
    ) : ITVEpisodeRepository = TVEpisodeRepository(tvEpisodeApi)
}