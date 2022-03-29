package com.lastfm.app.data.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Artist(
    @Json(name = "name")
    val name: String,
    @Json(name = "image")
    val image: List<Image>,
    @Json(name = "stats")
    val stats: Stats?,
    @Json(name = "bio")
    val bio: Bio?
) : Parcelable