package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Artist
import com.lastfm.app.data.api.dto.ArtistsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object ArtistsListMapper {

    @FromJson
    fun fromJson(artistsResponse: ArtistsResponse): ArtistsResponse {
        return artistsResponse
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: List<Artist>?) {
        throw UnsupportedOperationException()
    }
}