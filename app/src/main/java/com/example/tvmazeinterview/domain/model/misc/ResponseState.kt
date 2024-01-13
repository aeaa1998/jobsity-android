package com.example.tvmazeinterview.domain.model.misc


import java.lang.Exception

sealed class ResponseState <Response>{
    class Loading<Response>(): ResponseState<Response>()
    class Success<Response>(val response: Response): ResponseState<Response>()
    class Failed<Response>(val exception: Exception): ResponseState<Response>()
}