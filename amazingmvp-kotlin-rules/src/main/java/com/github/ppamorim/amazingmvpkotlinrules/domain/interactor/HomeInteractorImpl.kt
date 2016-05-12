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
import com.github.ppamorim.amazingmvpkotlinrules.domain.repository.getAll
import com.github.ppamorim.amazingmvpkotlinrules.domain.service.GenreService
import com.github.ppamorim.amazingmvpkotlinrules.domain.service.ServiceCallback
import com.github.ppamorim.threadexecutor.Interactor
import com.github.ppamorim.threadexecutor.InteractorExecutor
import com.github.ppamorim.threadexecutor.MainThread
import java.io.InputStream

/**
 * This class is the implementation of a async request,
 * all the logic is done on an Async Thread, using the
 * ThreadPool(as {@link InteractorExecutor}).
 */
class HomeInteractorImpl: Interactor, HomeInteractor {

  var interactorExecutor: InteractorExecutor? = null
  var mainThread: MainThread? = null
  var callback: HomeInteractor.Callback? = null

  override fun execute(callback: HomeInteractor.Callback?) {
    if (callback == null) {
      throw IllegalArgumentException("Callback parameter can't be null");
    }
    this.callback = callback;
    this.interactorExecutor?.run(this)
  }

  override fun run() {
    GenreService().requestGenres(object : ServiceCallback {
      override fun onSuccess(inputStream: InputStream) {
        val genres: List<Genre> = getAll(Genre::class.java)
        if (genres.count() > 0) {
          notifySuccess(genres)
        } else {
          notifyEmpty()
        }
      }
      override fun onError(statusCode: Int) {
        notifyError(statusCode)
      }
    })
  }

  fun notifySuccess(genres: List<Genre>) {
    mainThread!!.post { callback!!.onGenresLoaded(genres) }
  }

  fun notifyEmpty() {
    mainThread!!.post { callback!!.onGenresEmpty() }
  }

  fun notifyError(code: Int) {
    mainThread!!.post{ callback!!.onErrorLoad(code) }
  }

}