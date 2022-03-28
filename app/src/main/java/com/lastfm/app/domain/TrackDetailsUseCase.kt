package com.lastfm.app.domain

import com.lastfm.app.data.api.dto.TrackDetailsResponse
import com.lastfm.app.data.repository.LastFMRepository
import com.lastfm.app.network.NetworkApiRepositoryException
import com.lastfm.app.network.Type
import javax.inject.Inject

class TrackDetailsUseCase @Inject constructor(
    private val lastFMRepository: LastFMRepository
) {

    suspend fun execute(trackName: String, artistName: String): UseCaseResult<TrackDetailsResponse> =
        try {
            val trackDetails =
                lastFMRepository.getTrackDetails(trackName = trackName, artistName = artistName)
            UseCaseResult.SuccessResult(trackDetails)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Type.Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }

}