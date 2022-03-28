package com.lastfm.app.domain

import com.lastfm.app.data.api.dto.TracksResponse
import com.lastfm.app.data.repository.LastFMRepository
import com.lastfm.app.network.NetworkApiRepositoryException
import com.lastfm.app.network.Type
import javax.inject.Inject

class TracksUseCase @Inject constructor(
    private val lastFMRepository: LastFMRepository
) {

    suspend fun execute(trackName: String): UseCaseResult<TracksResponse> =
        try {
            val tracks = lastFMRepository.getTracks(trackName = trackName)
            UseCaseResult.SuccessResult(tracks)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Type.Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }

}