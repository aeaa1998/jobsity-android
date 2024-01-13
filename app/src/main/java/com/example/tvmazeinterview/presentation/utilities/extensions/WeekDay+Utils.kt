package com.example.tvmazeinterview.presentation.utilities.extensions

import com.example.tvmazeinterview.R
import com.example.tvmazeinterview.domain.model.misc.WeekDay
import com.example.tvmazeinterview.presentation.state.core.UIText

val WeekDay.text: UIText
    get() {
        val res = when(this) {
            WeekDay.Monday -> R.string.monday
            WeekDay.Tuesday -> R.string.tuesday
            WeekDay.Wednesday -> R.string.wednesday
            WeekDay.Thursday -> R.string.thursday
            WeekDay.Friday -> R.string.friday
            WeekDay.Saturday -> R.string.saturday
            WeekDay.Sunday -> R.string.sunday
        }

        return UIText.Resource(res)
    }