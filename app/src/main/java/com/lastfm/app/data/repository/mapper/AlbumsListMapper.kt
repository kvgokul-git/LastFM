package com.lastfm.app.data.repository.mapper

import com.lastfm.app.data.api.dto.Album
import com.lastfm.app.data.api.dto.AlbumsResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

internal object AlbumsListMapper {

    @FromJson
    fun fromJson(albumsResponse: AlbumsResponse): AlbumsResponse {
        return albumsResponse
    }

    @ToJson
    @Suppress("UNUSED_PARAMETER", "unused")
    fun toJson(writer: JsonWriter, value: List<Album>?) {
        throw UnsupportedOperationException()
    }
}