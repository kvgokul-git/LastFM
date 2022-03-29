package com.lastfm.app.ui.views.reusable_views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private const val LABEL_ALBUM = "Album : "
private const val LABEL_ARTIST = "Artist : "
private const val LABEL_TRACK = "Track : "
private const val LABEL_LISTENER = "Listener : "
private const val LABEL_PLAY_COUNT = "Play Count : "
private const val LABEL_CONTENT = "Content : "

@Composable
fun PageHeader(heading: String?) {
    heading?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun TextName(name: String?) {
    name?.let {
        Text(
            text = it,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun AlbumName(albumName: String?) {
    albumName?.let {
        Text(
            text = LABEL_ALBUM.plus(it),
            style = MaterialTheme.typography.button,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun ArtistName(artistName: String?) {
    artistName?.let {
        Text(
            text = LABEL_ARTIST.plus(it),
            style = MaterialTheme.typography.button,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun TrackName(trackName: String?) {
    trackName?.let {
        Text(
            text = LABEL_TRACK.plus(it),
            style = MaterialTheme.typography.button,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun Listener(listener: String?) {
    listener?.let {
        Text(
            text = LABEL_LISTENER.plus(it),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun PlayCount(playCount: String?) {
    playCount?.let {
        Text(
            text = LABEL_PLAY_COUNT.plus(it),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun WikiOrBio(wikiOrBio: String?) {
    wikiOrBio?.let {
        Text(
            text = LABEL_CONTENT.plus(it),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}
