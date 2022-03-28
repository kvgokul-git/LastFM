package com.lastfm.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lastfm.app.domain.AlbumDetailsUseCase
import com.lastfm.app.domain.ArtistDetailsUseCase
import com.lastfm.app.domain.TrackDetailsUseCase
import com.lastfm.app.domain.UseCaseResult
import com.lastfm.app.model.AlbumDetailsState
import com.lastfm.app.model.ArtistDetailsState
import com.lastfm.app.model.TrackDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastFMDetailsViewModel @Inject constructor(
    private val albumDetailsUseCase: AlbumDetailsUseCase,
    private val artistDetailsUseCase: ArtistDetailsUseCase,
    private val trackDetailsUseCase: TrackDetailsUseCase
) : ViewModel() {
    private val _albumDetailsViewState: MutableStateFlow<AlbumDetailsState> =
        MutableStateFlow(AlbumDetailsState.Loading)
    val albumDetailsViewState: StateFlow<AlbumDetailsState> = _albumDetailsViewState

    private val _artistDetailsViewState: MutableStateFlow<ArtistDetailsState> =
        MutableStateFlow(ArtistDetailsState.Loading)
    val artistDetailsViewState: StateFlow<ArtistDetailsState> = _artistDetailsViewState

    private val _trackDetailsViewState: MutableStateFlow<TrackDetailsState> =
        MutableStateFlow(TrackDetailsState.Loading)
    val trackDetailsViewState: StateFlow<TrackDetailsState> = _trackDetailsViewState

    private fun loadAlbumDetails(albumName: String, artistName: String) {
        viewModelScope.launch {
            _albumDetailsViewState.value =
                when (val result =
                    albumDetailsUseCase.execute(albumName = albumName, artistName = artistName)) {
                    is UseCaseResult.SuccessResult -> AlbumDetailsState.Loaded(result.value)
                    is UseCaseResult.NetworkErrorResult -> AlbumDetailsState.NetworkError
                    is UseCaseResult.GenericErrorResult -> AlbumDetailsState.GenericError
                }
        }
    }

    private fun loadArtistDetails(artistName: String) {
        viewModelScope.launch {
            _artistDetailsViewState.value =
                when (val result = artistDetailsUseCase.execute(artistName = artistName)) {
                    is UseCaseResult.SuccessResult -> ArtistDetailsState.Loaded(result.value)
                    is UseCaseResult.NetworkErrorResult -> ArtistDetailsState.NetworkError
                    is UseCaseResult.GenericErrorResult -> ArtistDetailsState.GenericError
                }
        }
    }

    private fun loadTrackDetails(trackName: String, artistName: String) {
        viewModelScope.launch {
            _trackDetailsViewState.value =
                when (val result =
                    trackDetailsUseCase.execute(trackName = trackName, artistName = artistName)) {
                    is UseCaseResult.SuccessResult -> TrackDetailsState.Loaded(result.value)
                    is UseCaseResult.NetworkErrorResult -> TrackDetailsState.NetworkError
                    is UseCaseResult.GenericErrorResult -> TrackDetailsState.GenericError
                }
        }
    }

}