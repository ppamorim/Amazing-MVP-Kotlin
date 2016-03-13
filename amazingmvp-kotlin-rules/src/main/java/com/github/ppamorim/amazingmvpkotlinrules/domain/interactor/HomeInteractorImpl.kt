package com.github.ppamorim.amazingmvpkotlinrules.domain.interactor

import com.github.ppamorim.threadexecutor.Interactor
import com.github.ppamorim.threadexecutor.InteractorExecutor
import com.github.ppamorim.threadexecutor.MainThread

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
        throw UnsupportedOperationException()
    }

}