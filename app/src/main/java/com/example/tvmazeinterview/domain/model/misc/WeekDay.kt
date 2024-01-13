package com.example.tvmazeinterview.domain.model.misc

enum class WeekDay {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

    companion object {
        fun from(value: String): WeekDay {
            return when(value.lowercase()) {
                "monday" -> Monday
                "Tuesday" -> Tuesday
                "Wednesday" -> Wednesday
                "Thursday" -> Thursday
                "Friday" -> Friday
                "Saturday" -> Saturday
                "Sunday" -> Sunday
                else -> Monday
            }
        }
    }
}