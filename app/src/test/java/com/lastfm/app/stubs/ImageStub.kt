package com.lastfm.app.stubs

import com.lastfm.app.data.api.dto.Image

@Suppress("MemberVisibilityCanBePrivate")
object ImageStub {

    private const val STUB_IMAGE_TEXT =
        "https://lastfm.freetls.fastly.net/i/u/300x300/3b54885952161aaea4ce2965b2db1638.png"
    private const val STUB_IMAGE_SIZE = "extralarge"

    fun new(
        text: String = STUB_IMAGE_TEXT,
        size: String = STUB_IMAGE_SIZE
    ) = Image(
        text = text,
        size = size
    )

}