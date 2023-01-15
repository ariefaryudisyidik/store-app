package com.ariefaryudisyidik.store.utils

import com.ariefaryudisyidik.store.data.remote.response.DefaultResponse
import com.google.gson.Gson
import retrofit2.HttpException

fun getMessage(httpException: HttpException): String {
    val body = httpException.response()?.errorBody()
    val adapter = Gson().getAdapter(DefaultResponse::class.java)
    val errorParser = adapter.fromJson(body?.string())
    return errorParser.message
}