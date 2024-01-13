package com.example.tvmazeinterview.data.source.remote.api.show

import com.example.tvmazeinterview.data.dto.show.TVShowDTO
import com.example.tvmazeinterview.domain.model.show.TVShow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVShowApi {
    @GET("shows")
    suspend fun getShows(@Query("page") page: Int) : List<TVShowDTO>

    @GET("shows/{id}")
    suspend fun show(@Path("id") id: Int) : TVShowDTO
}