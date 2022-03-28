package com.lastfm.app.model

import com.lastfm.app.data.api.dto.AlbumDetailsResponse

sealed class AlbumDetailsState {
    object Loading : AlbumDetailsState()
    data class Loaded(
        val albumDetails: AlbumDetailsResponse
    ) : AlbumDetailsState()

    object GenericError : AlbumDetailsState()
    object NetworkError : AlbumDetailsState()
}
