package com.github.ppamorim.amazingmvpkotlinrules.domain.service

import java.io.InputStream

interface ServiceCallback {
    fun onSuccess(inputStream: InputStream)
    fun onError(statusCode: Int)
}