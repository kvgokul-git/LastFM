package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Artist
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object ArtistMapper {

    @FromJson
    fun fromJson(artist: Artist): Artist {
        with(artist) {
            return Artist(
                name = name,
                image = image,
                stats = stats,
                bio = bio
            )
        }
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: Artist?) {
        throw UnsupportedOperationException()
    }
}