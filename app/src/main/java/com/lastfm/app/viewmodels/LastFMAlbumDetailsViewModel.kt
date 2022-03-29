package com.lastfm.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lastfm.app.domain.AlbumDetailsUseCase
import com.lastfm.app.domain.UseCaseResult
import com.lastfm.app.model.AlbumDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastFMAlbumDetailsViewModel @Inject constructor(
    private val albumDetailsUseCase: AlbumDetailsUseCase
) : ViewModel() {
    private val _albumDetailsViewState: MutableStateFlow<AlbumDetailsState> =
        MutableStateFlow(AlbumDetailsState.Loading)
    val albumDetailsViewState: StateFlow<AlbumDetailsState> = _albumDetailsViewState

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
}