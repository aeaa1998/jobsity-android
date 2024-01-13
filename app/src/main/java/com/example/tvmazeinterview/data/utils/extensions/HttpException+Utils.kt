package com.example.tvmazeinterview.data.utils.extensions

import android.util.Log
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.HttpException

/**
 * Function helper to parse an http exception into a [JSONObject] instance
 */
fun HttpException.toJsonObject(): JSONObject? {
    val jsonString = response()?.errorBody()?.string() ?: "{}"
    return try {
        val jsonError = JSONObject(jsonString)
        jsonError
    }catch (e: Exception){
        null
    }
}

/**
 * Function helper to parse an http exception into a [JSONArray] instance
 */
fun HttpException.toJsonArray(): JSONArray? {
    val jsonString = response()?.errorBody()?.string() ?: "{}"
    return try {
        val jsonError = JSONArray(jsonString)
        jsonError
    }catch (e: Exception){
        null
    }
}