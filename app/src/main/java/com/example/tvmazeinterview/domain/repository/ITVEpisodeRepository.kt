package com.example.tvmazeinterview.domain.repository

import com.example.tvmazeinterview.data.dto.episode.TVEpisodeDetailDTO
import com.example.tvmazeinterview.domain.model.episode.TVEpisode
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail

interface ITVEpisodeRepository {

    /**
     * Retrieves the list of espisodes
     * @param id [Int] The id of the show to retrieve the list of episodes
     */
    suspend fun getTVEpisodesFromShowId(id: Int) : List<TVEpisode>


    /**
     * Retrieves the detail
     * @param id [Int] The id for the episode to get it's detail
     */
    suspend fun getTVEpisode(id: Int) : TVEpisodeDetail
}