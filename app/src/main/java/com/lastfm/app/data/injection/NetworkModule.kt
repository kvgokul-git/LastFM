package com.lastfm.app.data.injection

import com.lastfm.app.config.ConfigProvider
import com.lastfm.app.config.MoshiAdapterConfig.getMoshiConfig
import com.lastfm.app.data.api.LastFMApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideLastFMApi(
        configProvider: ConfigProvider,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): LastFMApi {
        return Retrofit.Builder()
            .baseUrl(configProvider.apiBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(LastFMApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(configProvider: ConfigProvider) =
        HttpLoggingInterceptor().apply { level = if (configProvider.isDebug) BODY else NONE }

    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): Converter.Factory =
        MoshiConverterFactory.create(moshi).asLenient()

    @Provides
    @Singleton
    fun provideMoshiConfig(): Moshi = getMoshiConfig()
}