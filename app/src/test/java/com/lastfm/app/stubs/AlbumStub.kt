package com.lastfm.app.stubs

import com.lastfm.app.data.api.dto.Album
import com.lastfm.app.data.api.dto.Image
import com.lastfm.app.data.api.dto.Wiki

@Suppress("MemberVisibilityCanBePrivate")
object AlbumStub {
    const val STUB_ALBUM_NAME = "Believe"
    const val STUB_ARTIST_NAME = "Cher"
    const val STUB_LISTENER = "540968"
    const val STUB_PLAYCOUNT = "3906590"
    private val STUB_IMAGES = listOf(ImageStub.new())
    private val STUB_WIKI = WikiStub.new()

    fun new(
        name: String = STUB_ALBUM_NAME,
        artist: String = STUB_ARTIST_NAME,
        listeners: String = STUB_LISTENER,
        playCount: String = STUB_PLAYCOUNT,
        image: List<Image> = STUB_IMAGES,
        wiki: Wiki = STUB_WIKI
    ) = Album(
        name = name,
        artist = artist,
        listeners = listeners,
        playCount = playCount,
        image = image,
        wiki = wiki
    )
}