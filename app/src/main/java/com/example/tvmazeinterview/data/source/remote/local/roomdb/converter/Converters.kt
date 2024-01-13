package com.example.tvmazeinterview.data.source.remote.local.roomdb.converter

import androidx.room.TypeConverter
import com.example.tvmazeinterview.domain.model.show.TVShowSchedule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class Converters {
    @TypeConverter
    fun fromString(value: String?): ArrayList<String> {
        val listType= object : TypeToken<List<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<String?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToTVShowSchedule(value: String): TVShowSchedule =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<TVShowSchedule>(Types.getRawType(TVShowSchedule::class.java))
            .fromJson(value) ?: TVShowSchedule("00:00", emptyList())


    @TypeConverter
    fun fromTVShowScheduleToString(value: TVShowSchedule): String =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<TVShowSchedule>(Types.getRawType(TVShowSchedule::class.java))
            .toJson(value)




}