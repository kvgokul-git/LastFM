package com.lastfm.app.utils.base

import com.lastfm.app.network.NetworkApiCallDelegate
import com.lastfm.app.utils.rule.MockKRule
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.unmockkAll
import org.junit.Before
import org.junit.Rule

abstract class NetworkRepositoryTestBase<T: NetworkApiCallDelegate> {

    @Before
    fun tearDown() {
        unmockkAll()
    }

    @get:Rule
    val mockkRule = MockKRule()

    @MockK
    protected lateinit var mockNetworkApiCallDelegate: NetworkApiCallDelegate

    @InjectMockKs
    protected lateinit var subject : T

    protected infix fun <T : Any> ApiCallBlock<T>.returns(responseData: T){
        coEvery {
            mockApiCall()
        } returns responseData

        val slot = slot<suspend () -> T>()

        coEvery {
            mockNetworkApiCallDelegate.executeApiCall(capture(slot))
        } coAnswers {slot.captured.invoke()}
    }

    protected fun <T : Any> everyApiCallExceutionOf(apiCall: suspend () -> T) =
        ApiCallBlock(apiCall)

    protected class ApiCallBlock<T: Any>(val mockApiCall: suspend () -> T)

}