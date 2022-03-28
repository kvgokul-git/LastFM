package com.lastfm.app.ui.views

import androidx.navigation.NavController
import com.lastfm.app.data.api.dto.Album
import com.lastfm.app.data.api.dto.Artist
import com.lastfm.app.data.api.dto.Track

class LastFMNavigation(
    private val navController: NavController
) {

    fun navigateToAlbumDetailsScreen(album: Album) {
        navController.navigate(
            Screen.AlbumDetails.withArgs(
                album.name
            )
        )
    }

    fun navigateToArtistDetailsScreen(artist: Artist) {
        navController.navigate(
            Screen.ArtistDetails.withArgs(
                artist.name
            )
        )
    }

    fun navigateToTrackDetailsScreen(track: Track) {
        navController.navigate(
            Screen.TrackDetails.withArgs(
                track.name
            )
        )
    }
}