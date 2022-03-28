package com.lastfm.app.data.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "#text")
    val text: String,
    @Json(name = "size")
    val size: String
) : Parcelable