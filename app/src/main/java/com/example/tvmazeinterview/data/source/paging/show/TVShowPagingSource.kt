package com.example.tvmazeinterview.data.source.paging.show

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tvmazeinterview.data.source.remote.api.show.TVShowApi
import com.example.tvmazeinterview.data.utils.extensions.toJsonArray
import com.example.tvmazeinterview.data.utils.extensions.toJsonObject
import com.example.tvmazeinterview.domain.model.show.TVShow
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

class TVShowPagingSource (
    private val tvShowApi: TVShowApi,
) : PagingSource<Int, TVShow>() {
    override fun getRefreshKey(state: PagingState<Int, TVShow>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(0) ?: anchorPage?.nextKey?.minus(0)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TVShow> {
        val currentPage = params.key ?: 0
        return try {

            val tvShowsDtos = tvShowApi.getShows(currentPage)
            LoadResult.Page(
                data = tvShowsDtos.map { it.toEntity() },
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (tvShowsDtos.isEmpty()) null else currentPage + 1,
            )
        }
        catch (exception : HttpException) {
            val json = exception.toJsonArray()
            //We need to check because when we finish the list of items the status code is 404
            //So a exception is thrown but the error body is an empty array
            return if (json != null && json.length() == 0){
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = if (currentPage == 0) null else currentPage - 1,
                    nextKey = null,
                )
            }else{
                //It is another exception
                LoadResult.Error(exception)
            }

        }
        catch (exception : Exception) {
            LoadResult.Error(exception)
        }
    }

}