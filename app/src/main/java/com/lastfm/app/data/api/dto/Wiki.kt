package com.lastfm.app.data.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Wiki(
    @Json(name = "published")
    val published: String,
    @Json(name = "content")
    val content: String
) : Parcelable