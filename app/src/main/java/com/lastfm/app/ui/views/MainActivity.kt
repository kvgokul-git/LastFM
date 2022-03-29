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
import com.lastfm.app.ui.views.listscreen.AlbumsGrid
import com.lastfm.app.ui.views.listscreen.ArtistsGrid
import com.lastfm.app.ui.views.listscreen.TracksGrid
import com.lastfm.app.ui.views.reusable_views.*
import com.lastfm.app.viewmodels.LastFMListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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
                            Column(modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(rememberScrollState())) {
                                PageHeader(heading = "Albums")
                                AlbumsListWithViewModel(lastFMListViewModel = lastFMListViewModel)
                                MediumSpacer()
                                PageHeader(heading = "Artists")
                                ArtistsListWithViewModel(lastFMListViewModel = lastFMListViewModel)
                                MediumSpacer()
                                PageHeader(heading = "Tracks")
                                TracksListWithViewModel(lastFMListViewModel = lastFMListViewModel)
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
    lastFMListViewModel: LastFMListViewModel
) {
    val currentState: State<AlbumsListState> =
        lastFMListViewModel.albumsListViewState.collectAsState()
    when (val result = currentState.value) {
        is AlbumsListState.Loaded -> AlbumsGrid(albumsResponse = result.albums)
        is AlbumsListState.Loading -> LastFMStandardProgressBar()
        else -> Text(text = " Hello there is an error")
    }
}

@Composable
fun ArtistsListWithViewModel(
    lastFMListViewModel: LastFMListViewModel
) {
    val currentState: State<ArtistsListState> =
        lastFMListViewModel.artistsListViewState.collectAsState()
    when (val result = currentState.value) {
        is ArtistsListState.Loaded -> ArtistsGrid(artistsResponse = result.artists)
        is ArtistsListState.Loading -> LastFMStandardProgressBar()
        else -> Text(text = " Hello there is an error")
    }
}

@Composable
fun TracksListWithViewModel(
    lastFMListViewModel: LastFMListViewModel
) {
    val currentState: State<TracksListState> =
        lastFMListViewModel.tracksListViewState.collectAsState()
    when (val result = currentState.value) {
        is TracksListState.Loaded -> TracksGrid(tracksResponse = result.tracks)
        is TracksListState.Loading -> LastFMStandardProgressBar()
        else -> Text(text = " Hello there is an error")
    }
}
