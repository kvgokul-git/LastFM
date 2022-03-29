package com.lastfm.app.utils.base

import java.lang.IllegalArgumentException
import java.util.*

fun readFileAsString(clazz: Class<*>, name: String): String {
    val inputStream = clazz.classLoader?.getResourceAsStream(name)
        ?: throw IllegalArgumentException("File not found: $name")
    val scanner = Scanner(inputStream).useDelimiter("\\A")
    return if (scanner.hasNext()) scanner.next() else ""
}