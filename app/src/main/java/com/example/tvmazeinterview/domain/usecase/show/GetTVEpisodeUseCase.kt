package com.example.tvmazeinterview.domain.usecase.show

import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.domain.repository.ITVEpisodeRepository
import com.example.tvmazeinterview.domain.repository.ITVShowRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * Use case used to get the detail of the episode
 */
class GetTVEpisodeUseCase @Inject constructor(
    private val tvEpisodesRepository: ITVEpisodeRepository,
)  {
    suspend fun getEpisodeDetail(id: Int) = flow<ResponseState<TVEpisodeDetail>> {
        emit(ResponseState.Loading())
        try {
            val response = tvEpisodesRepository.getTVEpisode(id)
            emit(ResponseState.Success(response))
        }catch (e: Exception){
            emit(ResponseState.Failed(e))
        }
    }

}