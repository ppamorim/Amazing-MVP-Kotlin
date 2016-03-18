package com.github.ppamorim.amazingmvpkotlinrules.presenter

import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre

interface GenrePresenter: Presenter {
    fun setGenreView(genreView: View)
    fun setGenreObject(genre: Genre)
    interface View {
        fun isReady(): Boolean
        fun renderSubGenre(subGenres: List<SubGenre>)
    }
}