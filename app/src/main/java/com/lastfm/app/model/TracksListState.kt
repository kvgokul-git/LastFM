package com.lastfm.app.model

import com.lastfm.app.data.api.dto.TracksResponse

sealed class TracksListState {
    object Loading : TracksListState()
    data class Loaded(
        val tracks: TracksResponse
    ) : TracksListState()

    object GenericError : TracksListState()
    object NetworkError : TracksListState()
}
