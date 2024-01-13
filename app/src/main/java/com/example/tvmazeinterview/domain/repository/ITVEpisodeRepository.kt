package com.example.tvmazeinterview.domain.repository

import com.example.tvmazeinterview.data.dto.episode.TVEpisodeDetailDTO
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail

interface ITVEpisodeRepository {

    suspend fun getTVEpisodesFromShowId(id: Int) : List<TVEpisode>

    suspend fun getTVEpisode(id: Int) : TVEpisodeDetail
}