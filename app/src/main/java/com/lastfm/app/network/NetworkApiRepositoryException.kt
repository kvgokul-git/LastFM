package com.lastfm.app.network

import com.lastfm.app.network.Type.HttpError
import java.io.IOException
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class NetworkApiRepositoryException(val type: Type) : Exception() {

    fun isUnauthorisedError() = (type as? HttpError)?.errorCode == HTTP_UNAUTHORIZED

    fun isInternalServerError() = (type as? HttpError)?.errorCode == HTTP_INTERNAL_ERROR
}

sealed class Type {

    object Connection : Type()
    data class HttpError(val errorCode: Int, val errorMessage: String) : Type()
    object Generic : Type()
}

fun Throwable.isConnectionException() =
    this is SocketException || this is SocketTimeoutException || this is UnknownHostException || this is IOException

fun forEachOf(
    vararg errorTypes: Type,
    action: (error: NetworkApiRepositoryException) -> Unit
) {
    errorTypes.forEach { action(NetworkApiRepositoryException(it)) }
}