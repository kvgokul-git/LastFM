package com.lastfm.app.data.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Track(
    @Json(name = "name")
    val name: String,
    @Json(name = "artist")
    val artist: String,
    @Json(name = "image")
    val image: List<Image>
) : Parcelable