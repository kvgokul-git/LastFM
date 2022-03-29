package com.lastfm.app.ui.views

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.lastfm.app.ui.views.Screen.Companion.KEY_ALBUM_NAME
import com.lastfm.app.ui.views.Screen.Companion.KEY_ARTIST_NAME
import com.lastfm.app.ui.views.Screen.Companion.KEY_TRACK_NAME

sealed class Screen(val route: String) {
    object Listing : Screen(KEY_LISTING)
    object AlbumDetails : Screen(KEY_ALBUM_DETAILS)
    object ArtistDetails : Screen(KEY_ARTIST_DETAILS)
    object TrackDetails : Screen(KEY_TRACK_DETAILS)

    fun withArgs(vararg args: String?): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }

    companion object {
        const val KEY_ALBUM_NAME = "album"
        const val KEY_ARTIST_NAME = "artist"
        const val KEY_TRACK_NAME = "track"
        private const val KEY_LISTING = "listing"
        private const val KEY_ALBUM_DETAILS = "albumdetails"
        private const val KEY_ARTIST_DETAILS = "artistdetails"
        private const val KEY_TRACK_DETAILS = "trackdetails"
    }
}

val albumDetailsScreenArguments = listOf(
    navArgument(KEY_ALBUM_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    },
    navArgument(KEY_ARTIST_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    }
)

val artistDetailsScreenArguments = listOf(
    navArgument(KEY_ARTIST_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    }
)

val trackDetailsScreenArguments = listOf(
    navArgument(KEY_ARTIST_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    },
    navArgument(KEY_TRACK_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    }
)

