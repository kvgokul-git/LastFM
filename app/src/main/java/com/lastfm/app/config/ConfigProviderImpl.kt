package com.lastfm.app.config

import com.lastfm.app.BuildConfig

object ConfigProviderImpl : BaseCommonConfigProvider() {

    override val apiBaseUrl =
        BuildConfig.API_BASE_URL
}