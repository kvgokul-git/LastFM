package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Track
import com.lastfm.app.data.api.dto.TrackDetailsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object TrackDetailsMapper {

    @FromJson
    fun fromJson(trackDetailsResponse: TrackDetailsResponse): TrackDetailsResponse {
        return trackDetailsResponse
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: Track?) {
        throw UnsupportedOperationException()
    }
}