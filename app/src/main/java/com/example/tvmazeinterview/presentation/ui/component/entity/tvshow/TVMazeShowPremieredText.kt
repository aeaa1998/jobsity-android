package com.example.tvmazeinterview.presentation.ui.component.entity.tvshow

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.show.TVShow
import com.example.tvmazeinterview.presentation.utilities.extensions.format
import com.example.tvmazeinterview.presentation.utilities.extensions.toDate

@Composable
fun TVMazeShowPremieredText(tvShow: TVShow){
    val context = LocalContext.current
    val premieredText = remember(tvShow.premiered) {
        val text = tvShow.premiered?.toDate()?.format() ?: tvShow.premiered
        text ?: context.getString(R.string.premiered_not_available)
    }
    Text(
        text = premieredText,
        fontSize = 12.sp
    )
}