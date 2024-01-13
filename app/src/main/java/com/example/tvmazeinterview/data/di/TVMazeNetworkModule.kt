package com.example.tvmazeinterview.data.di

import com.example.tvmazeinterview.data.source.remote.api.show.TVShowApi
import com.example.tvmazeinterview.data.misc.TVDataModuleConstants
import com.example.tvmazeinterview.data.source.remote.api.episode.TVEpisodeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TVMazeNetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(httpLoggingInterceptor)



        return Retrofit.Builder().baseUrl(TVDataModuleConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpBuilder.build())
            .build()

    }

    @Singleton
    @Provides
    fun providesTVShowApi(retrofit: Retrofit): TVShowApi {
        return retrofit.create(TVShowApi::class.java)
    }

    @Singleton
    @Provides
    fun providesTVEpisodeApi(retrofit: Retrofit): TVEpisodeApi {
        return retrofit.create(TVEpisodeApi::class.java)
    }
}