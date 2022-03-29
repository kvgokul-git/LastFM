package com.lastfm.app.ui.views.listscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.lastfm.app.data.api.dto.*
import com.lastfm.app.ui.views.LastFMNavigation
import com.lastfm.app.ui.views.reusable_views.TextName
import com.lastfm.app.ui.views.reusable_views.XSmallSpacer


@Composable
fun DisplayAlbums(
    albumsResponse: AlbumsResponse,
    lastFMNavigation: LastFMNavigation
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow {
            albumsResponse.results.albumMatches?.let {
                items(it.album) { album ->
                    AlbumCard(album = album, lastFMNavigation = lastFMNavigation)
                }
            }
        }
    }
}

@Composable
fun AlbumCard(album: Album, lastFMNavigation: LastFMNavigation) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .widthIn(100.dp)
            .heightIn(200.dp)
            .clickable {
                lastFMNavigation.navigateToAlbumDetailsScreen(album = album)
            },
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(12.dp)
                .border(width = 1.dp, color = Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DisplayImages(url = album.image[2].text)
            XSmallSpacer()
            TextName(name = album.name)
        }
    }
}

@Composable
fun DisplayArtists(
    artistsResponse: ArtistsResponse,
    lastFMNavigation: LastFMNavigation
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow {
            artistsResponse.results.artistMatches?.let {
                items(it.artist) { artist ->
                    ArtistCard(artist = artist, lastFMNavigation = lastFMNavigation)
                }
            }
        }
    }
}

@Composable
fun ArtistCard(artist: Artist, lastFMNavigation: LastFMNavigation) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .widthIn(125.dp)
            .heightIn(250.dp)
            .clickable {
                lastFMNavigation.navigateToArtistDetailsScreen(artist = artist)
            },
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(12.dp)
                .border(width = 1.dp, color = Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DisplayImages(url = artist.image[2].text)
            XSmallSpacer()
            TextName(name = artist.name)
        }
    }
}

@Composable
fun DisplayTracks(
    tracksResponse: TracksResponse,
    lastFMNavigation: LastFMNavigation
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow {
            tracksResponse.results.trackMatches?.let {
                items(it.track) { track ->
                    TrackCard(track = track, lastFMNavigation = lastFMNavigation)
                }
            }
        }
    }
}

@Composable
fun TrackCard(track: Track, lastFMNavigation: LastFMNavigation) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .widthIn(125.dp)
            .heightIn(250.dp)
            .clickable {
                lastFMNavigation.navigateToTrackDetailsScreen(track = track)
            },
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(12.dp)
                .border(width = 1.dp, color = Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DisplayImages(url = track.image[2].text)
            XSmallSpacer()
            TextName(name = track.name)
        }
    }
}

@Composable
fun DisplayImages(url: String) {
    url?.let {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
    }
}