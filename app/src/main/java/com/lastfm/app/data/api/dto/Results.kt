package com.lastfm.app.data.api.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Results(
    @Json(name = "albummatches")
    val albumMatches: AlbumMatches,
    @Json(name = "artistmatches")
    val artistMatches: ArtistMatches,
    @Json(name = "trackmatches")
    val trackMatches: TrackMatches
) : Parcelable