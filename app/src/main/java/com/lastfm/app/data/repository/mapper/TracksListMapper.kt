package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.*
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object TracksListMapper {

    @FromJson
    fun fromJson(tracksResponse: TracksResponse): TracksResponse {
        return tracksResponse
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: List<Track>?) {
        throw UnsupportedOperationException()
    }
}