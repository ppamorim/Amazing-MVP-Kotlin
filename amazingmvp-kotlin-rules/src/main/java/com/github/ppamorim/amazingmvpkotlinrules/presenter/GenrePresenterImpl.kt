package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre
import com.github.ppamorim.amazingmvpkotlinrules.domain.util.Tags
import javax.inject.Inject

class GenrePresenterImpl @Inject constructor() : GenrePresenter {

  var subGenres: List<SubGenre> = emptyList()
  lateinit var view : GenrePresenter.GenreView

  override fun attachView(view: GenrePresenter.GenreView) {
    this.view = view
  }

  override fun addSubGenres(subGenres: List<SubGenre>) {
    this.subGenres = subGenres
  }

  override fun saveInstanceState(bundle: Bundle?): Bundle? {
    if (subGenres.isNotEmpty()) {
      bundle?.putParcelableArray(Tags.GENRE.value, subGenres.toTypedArray())
    }
    return bundle
  }

  override fun restoreInstanceState(bundle: Bundle?) {
    if(bundle?.containsKey(Tags.SUBGENRES.value) as Boolean) {
      subGenres = bundle?.getParcelableArray(Tags.SUBGENRES.value)
          ?.map { it as SubGenre } as List<SubGenre>
      bundle?.remove(Tags.SUBGENRES.value)
    }
    if (subGenres.isNotEmpty()) {
      view.renderSubGenres(subGenres)
    } else {
      view.showEmpty()
    }
  }

}