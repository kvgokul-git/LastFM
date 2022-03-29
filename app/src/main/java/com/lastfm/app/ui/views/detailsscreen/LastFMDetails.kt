package com.lastfm.app.ui.views.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.lastfm.app.data.api.dto.AlbumDetailsResponse
import com.lastfm.app.data.api.dto.ArtistDetailsResponse
import com.lastfm.app.data.api.dto.TrackDetailsResponse
import com.lastfm.app.ui.views.reusable_views.*

@Composable
fun AlbumDetails(albumDetailsResponse: AlbumDetailsResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        PageHeader(heading = albumDetailsResponse.album.name)
        MediumSpacer()
        DisplayLargeImage(url = albumDetailsResponse.album.image[3].text)
        LargeSpacer()
        ArtistName(artistName = albumDetailsResponse.album.artist)
        MediumSpacer()
        Listener(listener = albumDetailsResponse.album.listeners)
        MediumSpacer()
        PlayCount(playCount = albumDetailsResponse.album.playCount)
        MediumSpacer()
        albumDetailsResponse.album.wiki?.let {
            WikiOrBio(wikiOrBio = it.content)
        }
    }
}

@Composable
fun ArtistDetails(artistDetailsResponse: ArtistDetailsResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        PageHeader(heading = artistDetailsResponse.artist.name)
        MediumSpacer()
        DisplayLargeImage(url = artistDetailsResponse.artist.image[3].text)
        LargeSpacer()
        artistDetailsResponse.artist.stats?.let {
            Listener(listener = it.listeners)
        }
        MediumSpacer()
        artistDetailsResponse.artist.stats?.let {
            PlayCount(playCount = it.playcount)
        }
        MediumSpacer()
        artistDetailsResponse.artist.bio?.let {
            WikiOrBio(wikiOrBio = it.content)
        }
    }
}

@Composable
fun TrackDetails(trackDetailsResponse: TrackDetailsResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        PageHeader(heading = trackDetailsResponse.trackDetails.name)
        MediumSpacer()
        DisplayLargeImage(url = trackDetailsResponse.trackDetails.albumDetails.image[3].text)
        LargeSpacer()
        ArtistName(artistName = trackDetailsResponse.trackDetails.artistDetails.name)
        MediumSpacer()
        AlbumName(albumName = trackDetailsResponse.trackDetails.albumDetails.title)
        MediumSpacer()
        Listener(listener = trackDetailsResponse.trackDetails.listeners)
        MediumSpacer()
        PlayCount(playCount = trackDetailsResponse.trackDetails.playcount)
        MediumSpacer()
        WikiOrBio(wikiOrBio = trackDetailsResponse.trackDetails.wiki.content)
    }
}

@Composable
fun DisplayLargeImage(url: String) {
    url?.let {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
    }
}