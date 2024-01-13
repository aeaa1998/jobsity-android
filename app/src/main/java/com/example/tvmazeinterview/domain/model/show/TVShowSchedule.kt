package com.example.tvmazeinterview.domain.model.show

import com.example.tvmazeinterview.domain.model.misc.WeekDay

data class TVShowSchedule(
    val time: String,
    val days: List<WeekDay>,
)