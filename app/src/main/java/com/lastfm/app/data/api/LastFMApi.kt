package com.lastfm.app.data.api

import com.lastfm.app.BuildConfig
import com.lastfm.app.data.api.dto.*
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LastFMApi {

    companion object {
        const val LASTFM_API_ENDPOINT = "2.0?"
        const val METHOD_ALBUM_SEARCH = "album.search"
        const val METHOD_ALBUM_GET_INFO = "album.getinfo"
        const val METHOD_ARTIST_SEARCH = "artist.search"
        const val METHOD_ARTIST_GET_INFO = "artist.getinfo"
        const val METHOD_TRACK_SEARCH = "track.search"
        const val METHOD_TRACK_GET_INFO = "track.getInfo"
        const val API_RESPONSE_FORMAT = "json"
    }

    @GET(LASTFM_API_ENDPOINT)
    suspend fun getAlbums(
        @Query("album") albumName: String,
        @Query("method") method: String = METHOD_ALBUM_SEARCH,
        @Query("format") format: String = API_RESPONSE_FORMAT,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): AlbumsResponse

    @GET(LASTFM_API_ENDPOINT)
    suspend fun getAlbumInfo(
        @Query("album") albumName: String,
        @Query("artist") artistName: String,
        @Query("method") method: String = METHOD_ALBUM_GET_INFO,
        @Query("format") format: String = API_RESPONSE_FORMAT,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): AlbumDetailsResponse

    @GET(LASTFM_API_ENDPOINT)
    suspend fun getArtists(
        @Query("artist") artistName: String,
        @Query("method") method: String = METHOD_ARTIST_SEARCH,
        @Query("format") format: String = API_RESPONSE_FORMAT,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): ArtistsResponse

    @GET(LASTFM_API_ENDPOINT)
    suspend fun getArtistInfo(
        @Query("artist") artistName: String,
        @Query("method") method: String = METHOD_ARTIST_GET_INFO,
        @Query("format") format: String = API_RESPONSE_FORMAT,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): ArtistDetailsResponse

    @GET(LASTFM_API_ENDPOINT)
    suspend fun getTracks(
        @Query("track") trackName: String,
        @Query("method") method: String = METHOD_TRACK_SEARCH,
        @Query("format") format: String = API_RESPONSE_FORMAT,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): TracksResponse

    @GET(LASTFM_API_ENDPOINT)
    suspend fun getTrackInfo(
        @Query("track") trackName: String,
        @Query("artist") artistName: String,
        @Query("method") method: String = METHOD_TRACK_GET_INFO,
        @Query("format") format: String = API_RESPONSE_FORMAT,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): TrackDetailsResponse

}