package com.lastfm.app.data.injection

import com.lastfm.app.data.repository.LastFMRepository
import com.lastfm.app.data.repository.LastFMRepositoryImpl
import com.lastfm.app.network.NetworkApiCallDelegate
import com.lastfm.app.network.NetworkApiCallDelegateImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindNetworkApiExecutor(
        networkApiExecutorImpl: NetworkApiCallDelegateImpl
    ): NetworkApiCallDelegate

    @Binds
    @Singleton
    abstract fun bindLastFMRepository(
        lastFMRepositoryImpl: LastFMRepositoryImpl
    ): LastFMRepository

}