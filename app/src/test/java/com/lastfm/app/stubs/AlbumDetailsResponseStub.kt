package com.lastfm.app.stubs

import com.lastfm.app.data.api.dto.Album
import com.lastfm.app.data.api.dto.AlbumDetailsResponse

@Suppress("MemberVisibilityCanBePrivate")
object AlbumDetailsResponseStub {

    private val STUB_ALBUM = AlbumStub.new()

    fun new(
        album: Album = STUB_ALBUM
    ) = AlbumDetailsResponse(
        album = album
    )
}