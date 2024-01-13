package com.example.tvmazeinterview.presentation.utilities.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toDate(pattern: String = "yyyy-MM-dd"): LocalDate? {
    val inputFormatter = DateTimeFormatter.ofPattern(pattern)
    val date = LocalDate.parse(this, inputFormatter)
    return date
}