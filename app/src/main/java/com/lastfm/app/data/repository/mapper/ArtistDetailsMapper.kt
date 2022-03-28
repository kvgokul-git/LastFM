package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Artist
import com.lastfm.app.data.api.dto.ArtistDetailsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object ArtistDetailsMapper {

    @FromJson
    fun fromJson(artistDetailsResponse: ArtistDetailsResponse): ArtistDetailsResponse {
        return artistDetailsResponse
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: Artist?) {
        throw UnsupportedOperationException()
    }
}