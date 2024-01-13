package com.example.tvmazeinterview.data.dto.show

import com.example.tvmazeinterview.domain.model.misc.WeekDay
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.example.tvmazeinterview.domain.traits.interfaces.ToEntity
import com.google.gson.annotations.SerializedName


data class TVShowScheduleDTO(
    @SerializedName("time")
    val time: String,
    @SerializedName("days")
    val days: List<String>,
) : ToEntity<TVShowSchedule> {
    override fun toEntity() : TVShowSchedule = TVShowSchedule(time, days = days.map { WeekDay.from(it) })
}
