package com.example.tvmazeinterview.data.di

import android.app.Application
import androidx.room.Room
import com.example.tvmazeinterview.data.source.remote.local.roomdb.TVMazeDatabase
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.FavoriteTVMazeShowDao
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.TVMazeShowEntityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TVMazeDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): TVMazeDatabase = Room.databaseBuilder(
        application.applicationContext,
        TVMazeDatabase::class.java,
        "tv_maze_database"
    ).build()

    @Singleton
    @Provides
    fun provideFavoriteTVMazeShowDao(database: TVMazeDatabase): FavoriteTVMazeShowDao = database.getFavoriteTVMazeShowDao()

    @Singleton
    @Provides
    fun provideTVMazeShowEntityDao(database: TVMazeDatabase): TVMazeShowEntityDao = database.getTVMazeShowEntityDao()
}