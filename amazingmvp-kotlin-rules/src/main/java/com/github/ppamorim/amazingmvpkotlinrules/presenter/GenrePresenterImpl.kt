package com.github.ppamorim.amazingmvpkotlinrules.presenter

import android.os.Bundle
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre
import com.github.ppamorim.amazingmvpkotlinrules.domain.util.Tags

class GenrePresenterImpl: GenrePresenter {

    var view: GenrePresenter.View? = null
    var genre: Genre? = null

    override fun setGenreView(genreView: GenrePresenter.View) {
        this.view = genreView
    }

    override fun setGenreObject(genre: Genre) {
        this.genre = genre
        notifySubGenres(this.genre.subGenres)
    }

    override fun saveInstance(instance: Bundle?): Bundle? {
        if (instance != null && genre != null) {
            instance.putParcelable(Tags.GENRE.name(), genre)
        }
        return instance
    }

    override fun restoreInstance(instance: Bundle?) {
        if (instance != null) {
            if (instance.containsKey(Tags.GENRE.name())) {
                genre = instance.getParcelable(Tags.GENRE.name())
            }
        }
    }

    fun notifySubGenres(subGenres: List<SubGenre>) {
        if (this.view!!.isReady()) {
            this.view!!.renderSubGenre(subGenres)
        }
    }

}