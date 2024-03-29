package com.example.tvmazeinterview.presentation.ui.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.usecase.favorite.FavoriteTVShowUseCase
import com.example.tvmazeinterview.domain.usecase.show.GetTVShowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject


@OptIn(FlowPreview::class)
@HiltViewModel
class TVMazeShowHomeViewModel @Inject constructor(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val favoriteTVShowUseCase: FavoriteTVShowUseCase
) : ViewModel() {
    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _tvShows: MutableStateFlow<PagingData<TVShow>> = MutableStateFlow(PagingData.empty())
    val tvShows: StateFlow<PagingData<TVShow>>
        get() = _tvShows

    val favorites = favoriteTVShowUseCase.favorites
    init {
        viewModelScope.launch {
            favoriteTVShowUseCase.getFavorites()
            getTVShowUseCase.getTVShows(_query, favorites, this)
            .collect {
                _tvShows.value = it
            }
        }
    }

    fun setQuery(query: String) {
        _query.value = query
    }

    fun setFavorite(tvShow: TVShow) {
        viewModelScope.launch {
          favoriteTVShowUseCase.toggleFavorite(tvShow)
        }
    }



}