package com.lastfm.app.data.repository

import com.lastfm.app.data.api.LastFMApi
import com.lastfm.app.data.api.dto.*
import com.lastfm.app.network.NetworkApiCallDelegate
import javax.inject.Inject

class LastFMRepositoryImpl @Inject constructor(
    private val lastFMApi: LastFMApi,
    private val networkApiCallDelegate: NetworkApiCallDelegate
) : LastFMRepository, NetworkApiCallDelegate by networkApiCallDelegate {

    override suspend fun getAlbums(albumName: String): AlbumsResponse =
        executeApiCall { lastFMApi.getAlbums(albumName = albumName) }


    override suspend fun getAlbumDetails(albumName: String, artistName: String): AlbumDetailsResponse =
        executeApiCall { lastFMApi.getAlbumInfo(albumName = albumName, artistName = artistName) }


    override suspend fun getArtists(artistName: String): ArtistsResponse =
        executeApiCall { lastFMApi.getArtists(artistName = artistName) }


    override suspend fun getArtistDetails(artistName: String): ArtistDetailsResponse =
        executeApiCall { lastFMApi.getArtistInfo(artistName = artistName) }


    override suspend fun getTracks(trackName: String): TracksResponse =
        executeApiCall { lastFMApi.getTracks(trackName = trackName) }


    override suspend fun getTrackDetails(trackName: String, artistName: String): TrackDetailsResponse =
        executeApiCall { lastFMApi.getTrackInfo(trackName = trackName, artistName = artistName) }

}