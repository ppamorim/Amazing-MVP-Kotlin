package com.github.ppamorim.amazingmvpkotlinrules.domain.interactor

import com.bluelinelabs.logansquare.LoganSquare
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
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
        GenreService().requestGenres(object : ServiceCallback() {
            override fun onSuccess(inputStream: InputStream) {
                val genres: List<Genre>? = LoganSquare.parseList(inputStream, Genre::class.java)
                if (genres != null && genres.size() > 0) {
                    notifySuccess(genres)
                } else {
                    notifyEmpty(0)
                }
            }
            override fun onError(statusCode: Int) {
                notifyError(statusCode)
            }
        })
    }

    fun notifySuccess(genres: List<Genre>) {
        mainThread!!.post(Runnable {
            callback!!.onGenresLoaded(genres)
        })
    }

    fun notifyEmpty(reason: Int) {
        mainThread!!.post(Runnable {
            callback!!.onNoConnection(reason)
        })
    }

    fun notifyError(statusCode: Int) {
        mainThread!!.post(Runnable {
            callback!!.onErrorLoad()
        })
    }

}