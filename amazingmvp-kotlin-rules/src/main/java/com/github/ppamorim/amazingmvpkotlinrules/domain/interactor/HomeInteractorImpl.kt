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
package com.github.ppamorim.amazingmvpkotlinrules.domain.interactor

import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.domain.service.requestGenres
import com.github.ppamorim.threadexecutor.Interactor
import com.github.ppamorim.threadexecutor.InteractorExecutor
import com.github.ppamorim.threadexecutor.MainThread
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * This class is the implementation of a async request,
 * all the logic is done on an Async Thread, using the
 * ThreadPool(as {@link InteractorExecutor}).
 */
class HomeInteractorImpl @Inject constructor(
    val mainThread: MainThread,
    val interactorExecutor: InteractorExecutor,
    val okHttpClient: OkHttpClient):
    Interactor, HomeInteractor {

  lateinit var callback: HomeInteractor.Callback

  override fun execute(callback: HomeInteractor.Callback?) {
    if (callback == null) {
      throw IllegalArgumentException("Callback parameter can't be null");
    }
    this.callback = callback
    this.interactorExecutor.run(this)
  }

  override fun run() {
    requestGenres(okHttpClient, {
      if (it.count() > 0) {
        notifySuccess(it)
      } else {
        notifyEmpty()
      }
    }, { notifyError(it) })
  }

  fun notifySuccess(genres: List<Genre>) {
    mainThread.post { callback.onGenresLoaded(genres) }
  }

  fun notifyEmpty() {
    mainThread.post { callback.onGenresEmpty() }
  }

  fun notifyError(code: Int) {
    mainThread.post{ callback.onErrorLoad(code) }
  }

}