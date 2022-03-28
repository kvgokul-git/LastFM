package com.lastfm.app.config

interface ConfigProvider {

    val isDebug: Boolean

    val apiBaseUrl: String

}