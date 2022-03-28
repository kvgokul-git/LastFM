package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Track
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object TrackMapper {

    @FromJson
    fun fromJson(track: Track): Track {
        with(track) {
            return Track(
                name = name,
                artist = artist,
                image = image
            )
        }
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: Track?) {
        throw UnsupportedOperationException()
    }
}