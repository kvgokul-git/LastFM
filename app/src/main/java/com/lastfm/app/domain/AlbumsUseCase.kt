package com.lastfm.app.domain

import com.lastfm.app.data.api.dto.AlbumsResponse
import com.lastfm.app.data.repository.LastFMRepository
import com.lastfm.app.network.NetworkApiRepositoryException
import com.lastfm.app.network.Type
import javax.inject.Inject

class AlbumsUseCase @Inject constructor(
    private val lastFMRepository: LastFMRepository
) {

    suspend fun execute(albumName: String): UseCaseResult<AlbumsResponse> =
        try {
            val albums = lastFMRepository.getAlbums(albumName = albumName)
            UseCaseResult.SuccessResult(albums)
        } catch (networkApiRepositoryException: NetworkApiRepositoryException) {
            when (networkApiRepositoryException.type) {
                Type.Connection -> UseCaseResult.NetworkErrorResult
                else -> UseCaseResult.GenericErrorResult
            }
        }

}