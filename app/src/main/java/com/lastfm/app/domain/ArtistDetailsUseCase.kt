package com.lastfm.app.domain

import com.lastfm.app.data.api.dto.ArtistDetailsResponse
import com.lastfm.app.data.repository.LastFMRepository
import com.lastfm.app.network.NetworkApiRepositoryException
import com.lastfm.app.network.Type
import javax.inject.Inject

class ArtistDetailsUseCase @Inject constructor(
    private val lastFMRepository: LastFMRepository
) {

    suspend fun execute(artistName: String): UseCaseResult<ArtistDetailsResponse> =
        try {
            val artistDetails = lastFMRepository.getArtistDetails(artistName = artistName)
            UseCaseResult.SuccessResult(artistDetails)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Type.Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }

}