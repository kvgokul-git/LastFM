package com.lastfm.app.ui.views.listscreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import com.lastfm.app.model.AlbumsListState
import com.lastfm.app.model.ArtistsListState
import com.lastfm.app.model.TracksListState
import com.lastfm.app.ui.views.LastFMNavigation
import com.lastfm.app.ui.views.reusable_views.LastFMStandardProgressBar
import com.lastfm.app.viewmodels.LastFMListViewModel

@Composable
fun AlbumsListWithViewModel(
    lastFMListViewModel: LastFMListViewModel,
    lastFMNavigation: LastFMNavigation
) {
    val currentState: State<AlbumsListState> =
        lastFMListViewModel.albumsListViewState.collectAsState()
    when (val result = currentState.value) {
        is AlbumsListState.Loaded -> DisplayAlbums(
            albumsResponse = result.albums,
            lastFMNavigation = lastFMNavigation
        )
        is AlbumsListState.Loading -> LastFMStandardProgressBar()
        else -> Text(text = " Hello there is an error")
    }
}

@Composable
fun ArtistsListWithViewModel(
    lastFMListViewModel: LastFMListViewModel,
    lastFMNavigation: LastFMNavigation
) {
    val currentState: State<ArtistsListState> =
        lastFMListViewModel.artistsListViewState.collectAsState()
    when (val result = currentState.value) {
        is ArtistsListState.Loaded -> DisplayArtists(
            artistsResponse = result.artists,
            lastFMNavigation = lastFMNavigation
        )
        is ArtistsListState.Loading -> LastFMStandardProgressBar()
        else -> Text(text = " Hello there is an error")
    }
}

@Composable
fun TracksListWithViewModel(
    lastFMListViewModel: LastFMListViewModel,
    lastFMNavigation: LastFMNavigation
) {
    val currentState: State<TracksListState> =
        lastFMListViewModel.tracksListViewState.collectAsState()
    when (val result = currentState.value) {
        is TracksListState.Loaded -> DisplayTracks(
            tracksResponse = result.tracks,
            lastFMNavigation = lastFMNavigation
        )
        is TracksListState.Loading -> LastFMStandardProgressBar()
        else -> Text(text = " Hello there is an error")
    }
}