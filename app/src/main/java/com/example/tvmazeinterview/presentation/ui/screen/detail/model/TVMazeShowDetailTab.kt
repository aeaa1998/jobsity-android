package com.example.tvmazeinterview.presentation.ui.screen.detail.model

import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.presentation.state.core.UIText

enum class TVMazeShowDetailTab(val text: UIText) {
    Information(UIText.Resource(R.string.information)),
    Episodes(UIText.Resource(R.string.episodes));
}