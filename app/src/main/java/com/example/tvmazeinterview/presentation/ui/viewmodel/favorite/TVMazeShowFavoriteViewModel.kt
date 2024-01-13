package com.example.tvmazeinterview.presentation.ui.viewmodel.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.usecase.favorite.FavoriteTVShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVMazeShowFavoriteViewModel @Inject constructor(
    private val favoriteTVShowUseCase: FavoriteTVShowUseCase
) : ViewModel() {
    val favorites = favoriteTVShowUseCase.favorites

    fun toggleFavorite(tvShow: TVShow) =  viewModelScope.launch {
        favoriteTVShowUseCase.toggleFavorite(tvShow)
    }
}