package com.lastfm.app.utils.log

interface RemoteLogger {

    fun log(message: String)

    fun logRemoteException(throwable: Throwable)
}