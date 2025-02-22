package com.hasantaskin.cryptoapplication.util

//resoruce yani sonuçların düzenlendiği sınıf

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
    class Loading<T> : Resource<T>()
}