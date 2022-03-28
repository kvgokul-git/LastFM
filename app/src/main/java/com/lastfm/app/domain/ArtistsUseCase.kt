package com.lastfm.app.domain

import com.lastfm.app.data.api.dto.ArtistsResponse
import com.lastfm.app.data.repository.LastFMRepository
import com.lastfm.app.network.NetworkApiRepositoryException
import com.lastfm.app.network.Type
import javax.inject.Inject

class ArtistsUseCase @Inject constructor(
    private val lastFMRepository: LastFMRepository
) {

    suspend fun execute(artistName: String): UseCaseResult<ArtistsResponse> =
        try {
            val artists = lastFMRepository.getArtists(artistName = artistName)
            UseCaseResult.SuccessResult(artists)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Type.Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }

}