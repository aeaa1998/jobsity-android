package com.example.tvmazeinterview.data.repository.episode

import com.example.tvmazeinterview.data.dto.episode.TVEpisodeDetailDTO
import com.example.tvmazeinterview.data.source.remote.api.episode.TVEpisodeApi
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.domain.repository.ITVEpisodeRepository
import javax.inject.Inject

class TVEpisodeRepository @Inject constructor(private val tvEpisodeApi: TVEpisodeApi) : ITVEpisodeRepository {
    override suspend fun getTVEpisodesFromShowId(id: Int): List<TVEpisode> {
        val episodes = tvEpisodeApi.getEpisodesFromShow(id)
        return episodes.map { it.toEntity() }
    }

    override suspend fun getTVEpisode(id: Int): TVEpisodeDetail {
        return tvEpisodeApi.getEpisode(id).toEntity()
    }
}