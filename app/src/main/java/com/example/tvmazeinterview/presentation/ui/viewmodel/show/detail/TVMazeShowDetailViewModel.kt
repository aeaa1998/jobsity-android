package com.example.tvmazeinterview.presentation.ui.viewmodel.show.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.domain.model.show.TVShowDetail
import com.example.tvmazeinterview.domain.usecase.favorite.FavoriteTVShowUseCase
import com.example.tvmazeinterview.domain.usecase.show.GetTVShowUseCase
import com.example.tvmazeinterview.presentation.ui.screen.detail.model.TVMazeShowDetailTab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVMazeShowDetailViewModel @Inject constructor(
    val getTVShowUseCase: GetTVShowUseCase,
    val favoriteTVShowUseCase: FavoriteTVShowUseCase
) : ViewModel() {

    private val _state: MutableState<ResponseState<TVShowDetail>> = mutableStateOf(ResponseState.Loading())
    val state: State<ResponseState<TVShowDetail>>
        get() = _state

    private val _tab = mutableIntStateOf(0)
    val tab: State<Int>
        get() = _tab

    fun setTab(tab: Int) {
        _tab.value = tab
    }

    fun getTvShowDetail(id: Int) = viewModelScope.launch {
            getTVShowUseCase.getTVShowDetail(id)
                .collect { response ->
                    _state.value = response
                }

    }

    fun toggleFavorite(tvShow: TVShow) = viewModelScope.launch {
        favoriteTVShowUseCase.toggleFavorite(tvShow)
    }
}