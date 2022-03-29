package com.lastfm.app.ui.views

import androidx.navigation.NavType
import androidx.navigation.navArgument

private const val KEY_NAME = "name"

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
    navArgument(KEY_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    }
)

val artistDetailsScreenArguments = listOf(
    navArgument(KEY_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    }
)

val trackDetailsScreenArguments = listOf(
    navArgument(KEY_NAME) {
        type = NavType.StringType
        defaultValue = "love"
    }
)

