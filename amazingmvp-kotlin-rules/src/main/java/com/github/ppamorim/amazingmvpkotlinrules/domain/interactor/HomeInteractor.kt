package com.github.ppamorim.amazingmvpkotlinrules.domain.interactor

import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre

/**
 * This interface represents the connection between
 * the presenter and Interactor {@link HomeInteractorImpl}.
 * The callback will return the result of this
 * interactor for the presenter.
 */
interface HomeInteractor {
    fun execute(callback: Callback?)
    interface Callback {
        fun onGenresLoaded(subGenres: MutableList<Genre>)
        fun onGenresEmpty()
        fun onErrorLoad()
        fun onNoConnection(reason: Int)
    }
}