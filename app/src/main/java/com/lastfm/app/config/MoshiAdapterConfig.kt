package com.lastfm.app.config

import com.lastfm.app.data.repository.mapper.*
import com.squareup.moshi.Moshi

/**
 * Internal function that provides Moshi setup with all required mappers for use in both the
 * Network modules and unit tests.
 */
object MoshiAdapterConfig {
    fun getMoshiConfig(): Moshi =
        Moshi.Builder()
            .addProductMappers()
            .build()

    private fun Moshi.Builder.addProductMappers() =
        this.add(AlbumsListMapper)
            .add(ArtistsListMapper)
            .add(TracksListMapper)
            .add(AlbumDetailsMapper)
            .add(ArtistDetailsMapper)
            .add(TrackDetailsMapper)
            .add(AlbumMapper)
            .add(ArtistMapper)
            .add(TrackMapper)
}
