package com.example.tvmazeinterview.domain.di

import com.example.tvmazeinterview.domain.repository.ITVEpisodeRepository
import com.example.tvmazeinterview.domain.repository.ITVShowRepository
import com.example.tvmazeinterview.domain.usecase.show.GetTVEpisodeUseCase
import com.example.tvmazeinterview.domain.usecase.show.GetTVShowUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class TVMazeUseCaseModule {

    @Provides
    @Singleton
    fun providesGetTVShowUseCase(
        tvShowsRepository: ITVShowRepository,
        tvEpisodesRepository: ITVEpisodeRepository,
    ) = GetTVShowUseCase(tvShowsRepository, tvEpisodesRepository)

    @Provides
    @Singleton
    fun providesGetTVEpisodeUseCase(
        tvEpisodesRepository: ITVEpisodeRepository,
    ) = GetTVEpisodeUseCase(tvEpisodesRepository)
}