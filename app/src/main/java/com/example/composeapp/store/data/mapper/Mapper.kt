package com.example.composeapp.store.data.mapper

import com.example.composeapp.store.domain.model.NetworkError
import com.example.composeapp.store.domain.model.ApiError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when(this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknowResponse
        else -> ApiError.UnknowError
    }

    return NetworkError(
        error = error,
        t = this
    )
}