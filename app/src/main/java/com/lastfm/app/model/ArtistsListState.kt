package com.lastfm.app.model

import com.lastfm.app.data.api.dto.ArtistsResponse

sealed class ArtistsListState {
    object Loading : ArtistsListState()
    data class Loaded(
        val artists: ArtistsResponse
    ) : ArtistsListState()

    object GenericError : ArtistsListState()
    object NetworkError : ArtistsListState()
}
