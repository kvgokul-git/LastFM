package com.lastfm.app.ui.views.listscreen

import androidx.compose.foundation.border
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
import com.lastfm.app.data.api.dto.*
import com.lastfm.app.ui.views.reusable_views.CoilImage
import com.lastfm.app.ui.views.reusable_views.TextName
import com.lastfm.app.ui.views.reusable_views.XSmallSpacer


@Composable
fun AlbumsGrid(
    albumsResponse: AlbumsResponse
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow {
            albumsResponse.results.albumMatches?.let {
                items(it.album) { album ->
                    AlbumCard(album = album)
                }
            }
        }
    }
}

@Composable
fun AlbumCard(album: Album) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .widthIn(100.dp)
            .heightIn(200.dp),
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
            CoilImage(url = album.image[2].text, contentDescription = "album")
            XSmallSpacer()
            TextName(name = album.name)
        }
    }
}

@Composable
fun ArtistsGrid(
    artistsResponse: ArtistsResponse
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow {
            artistsResponse.results.artistMatches?.let {
                items(it.artist) { artist ->
                    ArtistCard(artist = artist)
                }
            }
        }
    }
}

@Composable
fun ArtistCard(artist: Artist) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .widthIn(125.dp)
            .heightIn(250.dp),
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
            CoilImage(url = artist.image[2].text, contentDescription = "artist")
            XSmallSpacer()
            TextName(name = artist.name)
        }
    }
}

@Composable
fun TracksGrid(
    tracksResponse: TracksResponse
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow {
            tracksResponse.results.trackMatches?.let {
                items(it.track) { track ->
                    TrackCard(track = track)
                }
            }
        }
    }
}

@Composable
fun TrackCard(track: Track) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .widthIn(125.dp)
            .heightIn(250.dp),
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
            CoilImage(url = track.image[2].text, contentDescription = "track")
            XSmallSpacer()
            TextName(name = track.name)
        }
    }
}