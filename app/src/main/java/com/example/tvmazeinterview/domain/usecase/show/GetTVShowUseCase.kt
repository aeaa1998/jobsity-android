package com.example.tvmazeinterview.domain.usecase.show

import androidx.paging.cachedIn
import androidx.paging.filter
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.domain.model.season.TVSeason
import com.example.tvmazeinterview.domain.model.show.TVShowDetail
import com.example.tvmazeinterview.domain.repository.ITVEpisodeRepository
import com.example.tvmazeinterview.domain.repository.ITVShowRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.lang.Exception
import javax.inject.Inject

class GetTVShowUseCase @Inject constructor(
    private val tvShowsRepository: ITVShowRepository,
    private val tvEpisodesRepository: ITVEpisodeRepository,
) {

    @OptIn(FlowPreview::class)
    fun getTVShows(query: Flow<String>, coroutineScope: CoroutineScope) = tvShowsRepository.searchShows()
        .cachedIn(coroutineScope)
        .combine(query.debounce(500)) { dataSet, queryString ->
            dataSet.filter { show -> show.name.lowercase().contains(queryString.lowercase()) }
        }
        .distinctUntilChanged()
        .cachedIn(coroutineScope)



    suspend fun getTVShowDetail(id: Int) = flow<ResponseState<TVShowDetail>> {
        emit(ResponseState.Loading())
        try {
            val result = coroutineScope {
                //Throw then async
                val tvShowJob = async { tvShowsRepository.showById(id) }
                val tvEpisodesJob = async { tvEpisodesRepository.getTVEpisodesFromShowId(id) }
                val tvShow = tvShowJob.await()
                val episodes = tvEpisodesJob.await()
                val episodesBySeason = episodes.groupBy { it.season }
                //Return the detail with the episodes
                TVShowDetail(
                    tvShow,
                    //Reduce the keys into a list of seasons
                    episodesBySeason.keys.fold(mutableListOf()) { carry, item ->
                        carry.add(TVSeason(item, episodesBySeason.getOrDefault(item, emptyList())))
                        carry
                    }
                )
            }
            emit(ResponseState.Success(result))
        }catch (e: Exception){
            emit(ResponseState.Failed(e))
        }
    }
}