package com.example.tvmazeinterview.presentation.utilities.extensions

fun String.normalize(parameters: Map<String, Any>): String {
    var formattedUrl = this
    parameters.forEach {
        formattedUrl = formattedUrl.replace("{${it.key}}", it.value.toString())
    }
    return formattedUrl
}