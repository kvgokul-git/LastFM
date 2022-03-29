package com.lastfm.app.data.repository

import com.google.common.truth.Truth.assertThat
import com.lastfm.app.data.api.LastFMApi
import com.lastfm.app.stubs.AlbumDetailsResponseStub
import com.lastfm.app.utils.base.NetworkRepositoryTestBase
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Test

class LastFMRepositoryImplTest : NetworkRepositoryTestBase<LastFMRepositoryImpl>() {

    private companion object {
        private const val ALBUM_NAME = "Believe"
        private const val ARTIST_NAME = "Cher"
    }

    @MockK
    private lateinit var mockApi: LastFMApi

    @Test
    fun `getAlbumDetails() - GIVEN call success, THEN retuns album details`() {
        val albumDetailsResponse = AlbumDetailsResponseStub.new()

        everyApiCallExceutionOf {
            mockApi.getAlbumInfo(
                ALBUM_NAME,
                ARTIST_NAME
            )
        } returns albumDetailsResponse

        runBlocking {
            assertThat(subject.getAlbumDetails(ALBUM_NAME, ARTIST_NAME)).isEqualTo(
                albumDetailsResponse
            )
        }

        coVerify { mockApi.getAlbumInfo(ALBUM_NAME, ARTIST_NAME) }
    }

}