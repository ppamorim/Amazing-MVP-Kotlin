package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre

interface HomePresenter : Presenter {
    fun requestGenres(savedInstanceState: Bundle?)
    interface View {
        fun isReady(): Boolean
        fun renderGenres(subGenres: MutableList<Genre>)
        fun showLoading()
        fun showError()
        fun showEmpty()
        fun showOffline(reason: Int)
    }
}