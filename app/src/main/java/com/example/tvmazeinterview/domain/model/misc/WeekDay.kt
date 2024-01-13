package com.example.tvmazeinterview.domain.model.misc

enum class WeekDay {
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;


    companion object {
        fun from(value: String): WeekDay {
            return when(value.lowercase()) {
                "monday" -> Monday
                "tuesday" -> Tuesday
                "wednesday" -> Wednesday
                "thursday" -> Thursday
                "friday" -> Friday
                "saturday" -> Saturday
                "sunday" -> Sunday
                else -> Monday
            }
        }
    }
}