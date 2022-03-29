package com.lastfm.app.ui.views

import androidx.navigation.NavType
import androidx.navigation.navArgument

private const val KEY_ALBUM_NAME = "album"
private const val KEY_ARTIST_NAME = "artist"
private const val KEY_TRACK_NAME = "track"

sealed class Screen(val route: String) {
    object Listing : Screen("listing")
    object AlbumDetails : Screen("albumdetails")
    object ArtistDetails : Screen("artistdetails")
    object TrackDetails : Screen("trackdetails")

    fun withArgs(vararg args: String?): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}

val albumDetailsScreenArguments = listOf(
    navArgument(KEY_ALBUM_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    },
    navArgument(KEY_ARTIST_NAME) {
        type= NavType.StringType
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

