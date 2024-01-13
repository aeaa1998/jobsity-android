package com.example.tvmazeinterview.domain.usecase.favorite

import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.repository.ITVShowRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteTVShowUseCase @Inject constructor(
    val tVShowRepository: ITVShowRepository
) {
    //The flow containing all the favorites
    private val _favorites = MutableStateFlow(emptyList<TVShow>())
    val favorites: StateFlow<List<TVShow>>
        get() = _favorites


    /**
     * Fetch and emit favorites
     */
    suspend fun getFavorites():StateFlow<List<TVShow>> {
        _favorites.emit(tVShowRepository.getFavorites())
        return favorites
    }

    /**
     * Handles the logic on how to toggle the favorite status
     * @param tvShow [TVShow] The TVShow we want to toggle
     */
    suspend fun toggleFavorite(tvShow: TVShow) {
        //Toggle
        val newValue = !tvShow.isFavorite.value
        tvShow.isFavorite.value = newValue
        processFavorite(tvShow, newValue)
        try {
            tVShowRepository.toggleFavorite(tvShow, favorite = newValue)

        }catch (e: Exception){
            //Revert the value
            tvShow.isFavorite.value = !newValue
            processFavorite(tvShow, !newValue)
        }
    }

    //Helper function to emit the value in the flow
    private suspend fun processFavorite(tvShow: TVShow, isFavorite: Boolean) {
        if (isFavorite){
            _favorites.emit(favorites.value.toMutableList().apply {
                add(tvShow)
            })
        }else{
            _favorites.emit(favorites.value.filter { it.id != tvShow.id })
        }
    }
}