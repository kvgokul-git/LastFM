package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Album
import com.lastfm.app.data.api.dto.AlbumDetailsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object AlbumDetailsMapper {

    @FromJson
    fun fromJson(albumDetailsResponse: AlbumDetailsResponse): AlbumDetailsResponse {
        return albumDetailsResponse
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: Album?) {
        throw UnsupportedOperationException()
    }
}