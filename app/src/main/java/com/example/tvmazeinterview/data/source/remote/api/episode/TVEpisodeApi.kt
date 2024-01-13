package com.example.tvmazeinterview.data.source.remote.api.episode

import com.example.tvmazeinterview.data.dto.episode.TVEpisodeDTO
import com.example.tvmazeinterview.data.dto.episode.TVEpisodeDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface TVEpisodeApi
{
    @GET("shows/{id}/episodes")
    suspend fun getEpisodesFromShow(@Path("id") id: Int) : List<TVEpisodeDTO>

    @GET("episodes/{id}")
    suspend fun getEpisode(@Path("id") id: Int) : TVEpisodeDetailDTO
}