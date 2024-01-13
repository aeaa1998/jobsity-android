package com.example.tvmazeinterview.presentation.state.core

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UIText {
    data class Raw(val _text: String) : UIText()
    data class Resource(@StringRes val id: Int) : UIText()


    val text: String
        @Composable
        get() = when (this){
            is Raw -> _text
            is Resource -> stringResource(id = id)
        }

}