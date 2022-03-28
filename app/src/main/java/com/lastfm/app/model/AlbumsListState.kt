package com.lastfm.app.model

import com.lastfm.app.data.api.dto.AlbumsResponse

sealed class AlbumsListState {
    object Loading : AlbumsListState()
    data class Loaded(
        val albums: AlbumsResponse
    ) : AlbumsListState()

    object GenericError : AlbumsListState()
    object NetworkError : AlbumsListState()
}
