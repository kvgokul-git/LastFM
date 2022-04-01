package com.lastfm.app.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lastfm.app.domain.AlbumsUseCase
import com.lastfm.app.domain.ArtistsUseCase
import com.lastfm.app.domain.TracksUseCase
import com.lastfm.app.domain.UseCaseResult
import com.lastfm.app.model.AlbumsListState
import com.lastfm.app.model.ArtistsListState
import com.lastfm.app.model.SearchWidgetState
import com.lastfm.app.model.TracksListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LastFMListViewModel @Inject constructor(
    private val albumsUseCase: AlbumsUseCase,
    private val artistsUseCase: ArtistsUseCase,
    private val tracksUseCase: TracksUseCase
) : ViewModel() {

    companion object {
        private const val DEFAULT_SEARCH_TERM = "Believe"
    }

    private val _albumsListViewState: MutableStateFlow<AlbumsListState> =
        MutableStateFlow(AlbumsListState.Loading)
    val albumsListViewState: StateFlow<AlbumsListState> = _albumsListViewState

    private val _artistsListViewState: MutableStateFlow<ArtistsListState> =
        MutableStateFlow(ArtistsListState.Loading)
    val artistsListViewState: StateFlow<ArtistsListState> = _artistsListViewState

    private val _tracksListViewState: MutableStateFlow<TracksListState> =
        MutableStateFlow(TracksListState.Loading)
    val tracksListViewState: StateFlow<TracksListState> = _tracksListViewState

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
        searchText = _searchTextState.value.ifEmpty {
            DEFAULT_SEARCH_TERM
        }
    }

    private var searchText: String = DEFAULT_SEARCH_TERM
        set(searchText) {
            field = searchText
            loadAlbums()
            loadArtists()
            loadTracks()
        }

    init {
        loadAlbums()
        loadArtists()
        loadTracks()
    }

    private fun loadAlbums() {
        viewModelScope.launch {
            _albumsListViewState.value =
                when (val result = albumsUseCase.execute(albumName = searchText)) {
                    is UseCaseResult.SuccessResult -> AlbumsListState.Loaded(result.value)
                    is UseCaseResult.NetworkErrorResult -> AlbumsListState.NetworkError
                    is UseCaseResult.GenericErrorResult -> AlbumsListState.GenericError
                }
        }
    }

    private fun loadArtists() {
        viewModelScope.launch {
            _artistsListViewState.value =
                when (val result = artistsUseCase.execute(artistName = searchText)) {
                    is UseCaseResult.SuccessResult -> ArtistsListState.Loaded(result.value)
                    is UseCaseResult.NetworkErrorResult -> ArtistsListState.NetworkError
                    is UseCaseResult.GenericErrorResult -> ArtistsListState.GenericError
                }
        }
    }

    private fun loadTracks() {
        viewModelScope.launch {
            _tracksListViewState.value =
                when (val result = tracksUseCase.execute(trackName = searchText)) {
                    is UseCaseResult.SuccessResult -> TracksListState.Loaded(result.value)
                    is UseCaseResult.NetworkErrorResult -> TracksListState.NetworkError
                    is UseCaseResult.GenericErrorResult -> TracksListState.GenericError
                }
        }
    }

}