package com.lastfm.app.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lastfm.app.model.AlbumsListState
import com.lastfm.app.model.ArtistsListState
import com.lastfm.app.model.TracksListState
import com.lastfm.app.ui.theme.LastFMTheme
import com.lastfm.app.ui.views.listscreen.DisplayAlbums
import com.lastfm.app.ui.views.listscreen.DisplayArtists
import com.lastfm.app.ui.views.listscreen.DisplayTracks
import com.lastfm.app.ui.views.reusable_views.*
import com.lastfm.app.viewmodels.LastFMListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private const val HEADING_ALBUMS = "Albums"
        private const val HEADING_ARTISTS = "Artists"
        private const val HEADING_TRACKS = "Tracks"
    }

    private val lastFMListViewModel: LastFMListViewModel by viewModels()

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
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
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
