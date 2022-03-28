package com.lastfm.app.data.repository

import com.lastfm.app.data.api.dto.AlbumDetailsResponse
import com.lastfm.app.data.api.dto.AlbumsResponse
import com.lastfm.app.data.api.dto.ArtistDetailsResponse
import com.lastfm.app.data.api.dto.ArtistsResponse
import com.lastfm.app.data.api.dto.TracksResponse
import com.lastfm.app.data.api.dto.TrackDetailsResponse

interface LastFMRepository {

    suspend fun getAlbums(albumName: String): AlbumsResponse

    suspend fun getAlbumDetails(albumName: String, artistName: String): AlbumDetailsResponse

    suspend fun getArtists(artistName: String): ArtistsResponse

    suspend fun getArtistDetails(artistName: String): ArtistDetailsResponse

    suspend fun getTracks(trackName: String): TracksResponse

    suspend fun getTrackDetails(trackName: String, artistName: String): TrackDetailsResponse
}