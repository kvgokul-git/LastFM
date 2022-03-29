package com.lastfm.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lastfm.app.domain.ArtistDetailsUseCase
import com.lastfm.app.domain.UseCaseResult
import com.lastfm.app.model.ArtistDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastFMArtistDetailsViewModel @Inject constructor(
    private val artistDetailsUseCase: ArtistDetailsUseCase
) : ViewModel() {
    private val _artistDetailsViewState: MutableStateFlow<ArtistDetailsState> =
        MutableStateFlow(ArtistDetailsState.Loading)
    val artistDetailsViewState: StateFlow<ArtistDetailsState> = _artistDetailsViewState

    fun loadArtistDetails(artistName: String) {
        viewModelScope.launch {
            _artistDetailsViewState.value =
                when (val result = artistDetailsUseCase.execute(artistName = artistName)) {
                    is UseCaseResult.SuccessResult -> ArtistDetailsState.Loaded(result.value)
                    is UseCaseResult.NetworkErrorResult -> ArtistDetailsState.NetworkError
                    is UseCaseResult.GenericErrorResult -> ArtistDetailsState.GenericError
                }
        }
    }

}