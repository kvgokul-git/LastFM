package com.lastfm.app.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lastfm.app.ui.theme.LastFMTheme
import com.lastfm.app.ui.views.detailsscreen.AlbumDetailsWithViewModel
import com.lastfm.app.ui.views.detailsscreen.ArtistDetailsWithViewModel
import com.lastfm.app.ui.views.detailsscreen.TrackDetailsWithViewModel
import com.lastfm.app.ui.views.listscreen.AlbumsListWithViewModel
import com.lastfm.app.ui.views.listscreen.ArtistsListWithViewModel
import com.lastfm.app.ui.views.listscreen.TracksListWithViewModel
import com.lastfm.app.ui.views.reusable_views.MainScreen
import com.lastfm.app.ui.views.reusable_views.MediumSpacer
import com.lastfm.app.ui.views.reusable_views.PageHeader
import com.lastfm.app.viewmodels.LastFMAlbumDetailsViewModel
import com.lastfm.app.viewmodels.LastFMArtistDetailsViewModel
import com.lastfm.app.viewmodels.LastFMListViewModel
import com.lastfm.app.viewmodels.LastFMTrackDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private const val HEADING_ALBUMS = "Albums"
        private const val HEADING_ARTISTS = "Artists"
        private const val HEADING_TRACKS = "Tracks"
    }

    private val lastFMListViewModel: LastFMListViewModel by viewModels()
    private val lastFMAlbumDetailsViewModel: LastFMAlbumDetailsViewModel by viewModels()
    private val lastFMArtistDetailsViewModel: LastFMArtistDetailsViewModel by viewModels()
    private val lastFMTrackDetailsViewModel: LastFMTrackDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LastFMTheme {
                val navController = rememberNavController()
                val lastFMNavigation = LastFMNavigation(navController)
                NavHost(
                    navController = navController,
                    startDestination = Screen.Listing.route
                ) {
                    composable(route = Screen.Listing.route) {
                        DefaultSurface {
                            Row(
                                modifier = Modifier
                                    .heightIn(56.dp)
                                    .fillMaxWidth()
                            ) {
                                MainScreen(lastFMListViewModel = lastFMListViewModel)
                            }
                            MediumSpacer()
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 65.dp)
                                    .verticalScroll(rememberScrollState())
                            ) {
                                PageHeader(heading = HEADING_ALBUMS)
                                AlbumsListWithViewModel(
                                    lastFMListViewModel = lastFMListViewModel,
                                    lastFMNavigation = lastFMNavigation
                                )
                                MediumSpacer()
                                PageHeader(heading = HEADING_ARTISTS)
                                ArtistsListWithViewModel(
                                    lastFMListViewModel = lastFMListViewModel,
                                    lastFMNavigation = lastFMNavigation
                                )
                                MediumSpacer()
                                PageHeader(heading = HEADING_TRACKS)
                                TracksListWithViewModel(
                                    lastFMListViewModel = lastFMListViewModel,
                                    lastFMNavigation = lastFMNavigation
                                )
                            }
                        }
                    }
                    composable(
                        route = Screen.AlbumDetails.route.plus("/{album}/{artist}"),
                        arguments = albumDetailsScreenArguments
                    ) { navBackStackEntry ->

                        val album = navBackStackEntry.arguments?.getString("album")
                        val artist = navBackStackEntry.arguments?.getString("artist")

                        DefaultSurface {
                            if (artist != null && album != null) {
                                AlbumDetailsWithViewModel(
                                    lastFMAlbumDetailsViewModel = lastFMAlbumDetailsViewModel,
                                    album = album,
                                    artist = artist
                                )
                            }
                        }

                    }
                    composable(
                        route = Screen.ArtistDetails.route.plus("/{artist}"),
                        arguments = artistDetailsScreenArguments
                    ) { navBackStackEntry ->

                        navBackStackEntry.arguments?.getString("artist")?.let {
                            DefaultSurface {
                                ArtistDetailsWithViewModel(
                                    lastFMArtistDetailsViewModel = lastFMArtistDetailsViewModel,
                                    artist = it
                                )
                            }
                        }
                    }
                    composable(
                        route = Screen.TrackDetails.route.plus("/{artist}/{track}"),
                        arguments = trackDetailsScreenArguments
                    ) { navBackStackEntry ->

                        val track = navBackStackEntry.arguments?.getString("track")
                        val artist = navBackStackEntry.arguments?.getString("artist")

                        DefaultSurface {
                            if (artist != null && track != null) {
                                TrackDetailsWithViewModel(
                                    lastFMTrackDetailsViewModel = lastFMTrackDetailsViewModel,
                                    track = track,
                                    artist = artist
                                )
                            }
                        }

                    }

                }

            }
        }
    }
}

// A surface container using the 'background' color from the theme
@Composable
fun DefaultSurface(content: @Composable () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        content.invoke()
    }
}




