package com.lastfm.app.model

import com.lastfm.app.data.api.dto.TrackDetailsResponse

sealed class TrackDetailsState {
    object Loading : TrackDetailsState()
    data class Loaded(
        val trackDetails: TrackDetailsResponse
    ) : TrackDetailsState()

    object GenericError : TrackDetailsState()
    object NetworkError : TrackDetailsState()
}
