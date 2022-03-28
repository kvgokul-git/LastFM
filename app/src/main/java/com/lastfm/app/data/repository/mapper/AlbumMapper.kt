package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Album
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object AlbumMapper {

    @FromJson
    fun fromJson(album: Album): Album {
        with(album) {
            return Album(
                name = name,
                artist = artist,
                listeners = listeners,
                playCount = playCount,
                image = image,
                wiki = wiki
            )
        }
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: Album?) {
        throw UnsupportedOperationException()
    }
}