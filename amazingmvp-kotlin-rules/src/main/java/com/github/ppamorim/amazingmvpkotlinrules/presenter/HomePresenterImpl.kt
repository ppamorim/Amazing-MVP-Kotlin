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
package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle
import com.github.ppamorim.amazingmvpkotlinrules.domain.interactor.HomeInteractor
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.domain.util.Tags
import javax.inject.Inject

class HomePresenterImpl @Inject constructor(interactor : HomeInteractor) :
    PresenterImpl<HomePresenter.HomeView, HomeInteractor>(interactor), HomePresenter {

  var genres: List<Genre> = emptyList()

  override fun attachView(view: HomePresenter.HomeView) {
    this.view = view
  }

  override fun requestGenres() {
    if (genres.isEmpty()) {
      notifyLoading()
      interactor?.execute(object: HomeInteractor.Callback {
        override fun onGenresLoaded(genres: List<Genre>) = notifyGenreLoaded(genres)
        override fun onGenresEmpty() = notifyEmpty()
        override fun onErrorLoad(code: Int) = notifyError(code)
      })
    } else {
      notifyGenreLoaded(genres)
    }
  }

  override fun saveInstanceState(bundle: Bundle?): Bundle? {
    if (genres.isNotEmpty()) {
      bundle?.putParcelableArray(Tags.GENRES.value, genres.toTypedArray())
    }
    return bundle
  }

  override fun restoreInstanceState(bundle: Bundle?) {
    if(bundle?.containsKey(Tags.GENRES.value) as Boolean) {
      genres = bundle?.getParcelableArray(Tags.GENRES.value)
          ?.map { it as Genre } as List<Genre>
      bundle?.remove(Tags.GENRES.value)
    }
  }

  private fun notifyLoading() {
    if (view?.ready() as Boolean) {
      view?.showLoading()
    }
  }

  private fun notifyGenreLoaded(subGenres: List<Genre>) {
    if (view?.ready() as Boolean) {
      view?.renderGenres(subGenres)
    }
  }

  private fun notifyEmpty() {
    if (view?.ready() as Boolean) {
      view?.showEmpty()
    }
  }

  private fun notifyError(code: Int) {
    if (view?.ready() as Boolean) {
      view?.showError(code)
    }
  }

}