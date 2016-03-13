/*
* Copyright (C) 2016 Pedro Paulo de Amorim
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.github.ppamorim.amazingmvpkotlinrules.domain.service

import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * This is a base class to do request to a
 * determined address and it handles the
 * success or error.
 */
open class BaseService {

    var okHttpClient : OkHttpClient? = null

    fun get(url : String, callback : ServiceCallback) {
        val request = Request.Builder()
                .url(url)
                .build()
        val response = okHttpClient?.newCall(request)?.execute()
        if(response!!.isSuccessful()) {
            callback.onSuccess(response.body().byteStream())
        } else {
            callback.onError(response.code())
        }
    }

}