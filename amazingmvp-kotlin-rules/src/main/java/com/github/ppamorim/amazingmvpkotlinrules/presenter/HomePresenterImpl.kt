package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle

class HomePresenterImpl : HomePresenter {

    var view : HomePresenter.View? = null

    override fun setViewInterface(view: HomePresenter.View) {
        this.view = view
    }

    override fun requestGenres(savedInstanceState: Bundle?) {
        throw UnsupportedOperationException()
    }

    override fun saveInstance(instance: Bundle): Bundle {
        return instance
    }

    override fun restoreInstance(instance: Bundle) {
        throw UnsupportedOperationException()
    }

}