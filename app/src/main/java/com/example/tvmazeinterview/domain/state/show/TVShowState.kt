package com.example.tvmazeinterview.domain.state.show

import com.example.tvmazeinterview.domain.model.show.TVShow

sealed class TVShowState {
    class Loading : TVShowState()
    data class Success(val shows: List<TVShow>) : TVShowState()
    data class Failed(val error: Error) : TVShowState()
}
