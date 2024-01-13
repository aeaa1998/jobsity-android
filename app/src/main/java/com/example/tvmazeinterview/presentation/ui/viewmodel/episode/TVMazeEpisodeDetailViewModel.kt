package com.example.tvmazeinterview.presentation.ui.viewmodel.episode

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvmazeinterview.domain.model.episode.TVEpisodeDetail
import com.example.tvmazeinterview.domain.model.misc.ResponseState
import com.example.tvmazeinterview.domain.usecase.show.GetTVEpisodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TVMazeEpisodeDetailViewModel @Inject constructor(
    val getTVEpisodeUseCase: GetTVEpisodeUseCase
) : ViewModel() {

    private val _episodeDetailState = mutableStateOf<ResponseState<TVEpisodeDetail>>(ResponseState.Loading())
    val episodeDetailState: State<ResponseState<TVEpisodeDetail>>
        get() = _episodeDetailState

    fun getEpisodeDetail(id: Int) = viewModelScope.launch {
        getTVEpisodeUseCase.getEpisodeDetail(id)
            .collect {
                _episodeDetailState.value = it
            }
    }
}