package com.github.ppamorim.amazingmvpkotlinrules.presenter

import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre

interface GenrePresenter : Presenter<GenrePresenter.GenreView> {
  fun addSubGenres(subGenres: List<SubGenre>)
  interface GenreView: View {
    fun renderSubGenres(subGenres: List<SubGenre>)
    fun showEmpty()
  }
}