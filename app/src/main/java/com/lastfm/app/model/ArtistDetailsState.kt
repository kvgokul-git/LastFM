package com.lastfm.app.model

import com.lastfm.app.data.api.dto.ArtistDetailsResponse

sealed class ArtistDetailsState {
    object Loading : ArtistDetailsState()
    data class Loaded(
        val artistDetails: ArtistDetailsResponse
    ) : ArtistDetailsState()

    object GenericError : ArtistDetailsState()
    object NetworkError : ArtistDetailsState()
}
