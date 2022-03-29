package com.lastfm.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lastfm.app.domain.TrackDetailsUseCase
import com.lastfm.app.domain.UseCaseResult
import com.lastfm.app.model.TrackDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastFMTrackDetailsViewModel @Inject constructor(
    private val trackDetailsUseCase: TrackDetailsUseCase
) : ViewModel() {
    private val _trackDetailsViewState: MutableStateFlow<TrackDetailsState> =
        MutableStateFlow(TrackDetailsState.Loading)
    val trackDetailsViewState: StateFlow<TrackDetailsState> = _trackDetailsViewState

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