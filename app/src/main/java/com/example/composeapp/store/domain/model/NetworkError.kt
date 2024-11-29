package com.example.composeapp.store.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
)

enum class ApiError(val message: String) {
    NetworkError("Network Error"),
    UnknowResponse("Unknow Response"),
    UnknowError("Unknow Error")
}