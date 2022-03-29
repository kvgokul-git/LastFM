package com.lastfm.app.ui.views.detailsscreen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.lastfm.app.model.AlbumDetailsState
import com.lastfm.app.model.ArtistDetailsState
import com.lastfm.app.model.TrackDetailsState
import com.lastfm.app.ui.views.reusable_views.LastFMStandardProgressBar
import com.lastfm.app.viewmodels.LastFMAlbumDetailsViewModel
import com.lastfm.app.viewmodels.LastFMArtistDetailsViewModel
import com.lastfm.app.viewmodels.LastFMTrackDetailsViewModel

@Composable
fun AlbumDetailsWithViewModel(
    lastFMAlbumDetailsViewModel: LastFMAlbumDetailsViewModel,
    album: String,
    artist: String
) {
    lastFMAlbumDetailsViewModel.loadAlbumDetails(albumName = album, artistName = artist)
    val currentState: State<AlbumDetailsState> =
        lastFMAlbumDetailsViewModel.albumDetailsViewState.collectAsState()
    when (val result = currentState.value) {
        is AlbumDetailsState.Loaded -> AlbumDetails(albumDetailsResponse = result.albumDetails)
        is AlbumDetailsState.Loading -> LastFMStandardProgressBar()
        else -> Text(
            text = " Hello there is an error with details screen",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onError
        )
    }
}

@Composable
fun ArtistDetailsWithViewModel(
    lastFMArtistDetailsViewModel: LastFMArtistDetailsViewModel,
    artist: String
) {
    lastFMArtistDetailsViewModel.loadArtistDetails(artistName = artist)
    val currentState: State<ArtistDetailsState> =
        lastFMArtistDetailsViewModel.artistDetailsViewState.collectAsState()
    when (val result = currentState.value) {
        is ArtistDetailsState.Loaded -> ArtistDetails(artistDetailsResponse = result.artistDetails)
        is ArtistDetailsState.Loading -> LastFMStandardProgressBar()
        else -> Text(
            text = " Hello there is an error with details screen",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onError
        )
    }
}

@Composable
fun TrackDetailsWithViewModel(
    lastFMTrackDetailsViewModel: LastFMTrackDetailsViewModel,
    track: String,
    artist: String
) {
    lastFMTrackDetailsViewModel.loadTrackDetails(trackName = track, artistName = artist)
    val currentState: State<TrackDetailsState> =
        lastFMTrackDetailsViewModel.trackDetailsViewState.collectAsState()
    when (val result = currentState.value) {
        is TrackDetailsState.Loaded -> TrackDetails(trackDetailsResponse = result.trackDetails)
        is TrackDetailsState.Loading -> LastFMStandardProgressBar()
        else -> Text(
            text = " Hello there is an error with details screen",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onError
        )
    }
}