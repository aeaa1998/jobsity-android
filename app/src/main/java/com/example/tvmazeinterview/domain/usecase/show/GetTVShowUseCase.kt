package com.example.tvmazeinterview.domain.usecase.show

import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.domain.model.season.TVSeason
import com.example.tvmazeinterview.domain.model.show.TVShow
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


/**
 * Use case used to get the pagination and the detail of the shows
 */
class GetTVShowUseCase @Inject constructor(
    private val tvShowsRepository: ITVShowRepository,
    private val tvEpisodesRepository: ITVEpisodeRepository,
) {

    /**
     * Handles the logic of the pagination
     * @param query [Flow] Uses the flow query to combine it
     * @param favorites [Flow] Uses the favorites query to combine it
     * @param coroutineScope [CoroutineScope] The coroutine to cache in
     */
    @OptIn(FlowPreview::class)
    fun getTVShows(query: Flow<String>, favorites: Flow<List<TVShow>>, coroutineScope: CoroutineScope) = tvShowsRepository.searchShows()
        .cachedIn(coroutineScope)
        //After pagination we will need to filter by query
        .combine(query.debounce(500)) { dataSet, queryString ->
            dataSet
                .filter { show -> show.name.lowercase().contains(queryString.lowercase()) }
        }
        //After filtering lets see which ones are favorites
        .combine(favorites) { dataSet, favoritesTvs ->
            val ids = favoritesTvs.map { it.id }
            dataSet.map {
                it.isFavorite.value = ids.contains(it.id)
                it
            }
        }
        .distinctUntilChanged()
        .cachedIn(coroutineScope)



    suspend fun getTVShowDetail(id: Int) = flow<ResponseState<TVShowDetail>> {
        emit(ResponseState.Loading())
        try {
            val result = coroutineScope {
                //Throw them async for better performance
                val tvShowJob = async { tvShowsRepository.showById(id) }
                val tvEpisodesJob = async { tvEpisodesRepository.getTVEpisodesFromShowId(id) }
                val favoriteJob = async {
                    try {
                        tvShowsRepository.getFavoritesById(id)
                    }catch (e: Exception){
                        null
                    }
                }
                val tvShow = tvShowJob.await()
                val episodes = tvEpisodesJob.await()
                val favorite = favoriteJob.await()

                val episodesBySeason = episodes.groupBy { it.season }
                //Return the detail with the episodes
                TVShowDetail(
                    tvShow.apply {
                         isFavorite.value = favorite != null
                    },
                    //Reduce the keys into a list of seasons
                    episodesBySeason.keys.fold(mutableListOf()) { carry, item ->
                        carry.add(TVSeason(item, episodesBySeason.getOrDefault(item, emptyList())))
                        carry
                    }
                )
            }
            //Emit everything went okay
            emit(ResponseState.Success(result))
        }catch (e: Exception){
            emit(ResponseState.Failed(e))
        }
    }
}