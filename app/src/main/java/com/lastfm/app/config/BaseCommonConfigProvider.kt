package com.lastfm.app.config

import com.lastfm.app.BuildConfig

abstract class BaseCommonConfigProvider : ConfigProvider {

    override val isDebug = BuildConfig.DEBUG
}