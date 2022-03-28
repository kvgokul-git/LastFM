package com.lastfm.app.network

import com.lastfm.app.utils.log.RemoteLogger
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import javax.inject.Inject

interface NetworkApiCallDelegate {
    @Throws(NetworkApiRepositoryException::class)
    suspend fun <T : Any> executeApiCall(apiCall: suspend () -> T): T
}

internal class NetworkApiCallDelegateImpl @Inject constructor(
    private val remoteLogger: RemoteLogger
) : NetworkApiCallDelegate {

    @Throws(NetworkApiRepositoryException::class)
    override suspend fun <T : Any> executeApiCall(apiCall: suspend () -> T): T {
        return try {
            apiCall()
        } catch (throwable: Throwable) {
            val errorType = getErrorType(throwable)
            throw NetworkApiRepositoryException(errorType)
        }
    }

    private fun getErrorType(throwable: Throwable): Type {
        return when {
            throwable.isConnectionException() -> {
                Type.Connection
            }
            throwable is JsonDataException -> {
                // Log any json data exceptions, as it flags any data that we're not expecting
                // back from the server
                remoteLogger.logRemoteException(throwable)
                Type.Generic
            }
            throwable is HttpException -> {
                Type.HttpError(throwable.code(), throwable.message())
            }
            else -> {
                Type.Generic
            }
        }
    }
}