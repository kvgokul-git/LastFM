package com.lastfm.app.data.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class TrackDetails(
    @Json(name = "name")
    val name: String,
    @Json(name = "artist")
    val artistDetails: ArtistDetails,
    @Json(name = "album")
    val albumDetails: AlbumDetails,
    @Json(name = "listeners")
    val listeners: String,
    @Json(name = "playcount")
    val playcount: String,
    @Json(name = "wiki")
    val wiki: Wiki
) : Parcelable