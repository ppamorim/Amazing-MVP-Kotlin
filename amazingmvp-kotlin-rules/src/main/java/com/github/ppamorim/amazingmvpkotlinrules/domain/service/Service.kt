package com.github.ppamorim.amazingmvpkotlinrules.domain.service

import okhttp3.*
import okio.BufferedSource

fun get(okHttp: OkHttpClient, url : String,
        success: (BufferedSource) -> Unit,
        error: (code: Int) -> Unit) {
  handleResponse(response(call(
      okHttp,
      request(url).build())),
      success,
      error)
}

fun post(okHttp: OkHttpClient,
         url : String,
         requestBody : RequestBody,
         success: (BufferedSource) -> Unit,
         error: (code: Int) -> Unit) {
  handleResponse(response(call(
      okHttp ,
      request(url).post(requestBody).build())),
      success,
      error)
}

private fun handleResponse(response: Response,
                           success: (BufferedSource) -> Unit,
                           error: (code: Int) -> Unit) {
  if (response.isSuccessful) {
    val body = response.body()
    success(body.source())
    body.close()
  } else {
    error(response.code())
  }
}

private fun request(url : String) : Request.Builder = Request.Builder().url(url)
private fun call(okHttp: OkHttpClient, request: Request) : Call = okHttp.newCall(request)
private fun response(call : Call) : Response = call.execute()