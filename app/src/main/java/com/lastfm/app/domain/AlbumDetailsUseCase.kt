package com.lastfm.app.domain

import com.lastfm.app.data.api.dto.AlbumDetailsResponse
import com.lastfm.app.data.repository.LastFMRepository
import com.lastfm.app.network.NetworkApiRepositoryException
import com.lastfm.app.network.Type
import javax.inject.Inject

class AlbumDetailsUseCase @Inject constructor(
    private val lastFMRepository: LastFMRepository
) {

    suspend fun execute(albumName: String, artistName: String): UseCaseResult<AlbumDetailsResponse> =
        try {
            val albumDetails =
                lastFMRepository.getAlbumDetails(albumName = albumName, artistName = artistName)
            UseCaseResult.SuccessResult(albumDetails)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Type.Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }

}