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