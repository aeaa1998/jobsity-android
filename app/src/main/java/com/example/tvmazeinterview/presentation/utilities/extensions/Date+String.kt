package com.example.tvmazeinterview.presentation.utilities.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun LocalDate.format(pattern: String = "MMMM dd, yyyy"): String? {
    val outputFormatter = DateTimeFormatter.ofPattern(pattern)
    return outputFormatter.format(this)
}