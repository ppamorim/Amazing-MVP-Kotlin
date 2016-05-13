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
package com.amazingmvpkotlin.ui.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.amazingmvpkotlin.R
import com.amazingmvpkotlin.di.GenreModule
import com.amazingmvpkotlin.di.components.DaggerGenreComponent
import com.amazingmvpkotlin.di.components.GenreComponent
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.SubGenre
import com.github.ppamorim.amazingmvpkotlinrules.domain.util.Tags
import com.github.ppamorim.amazingmvpkotlinrules.presenter.GenrePresenter
import javax.inject.Inject

class GenreFragment: AbstractFragment(), GenrePresenter.GenreView {

  var genreComponent: GenreComponent? = null

  @Inject lateinit var genrePresenter: GenrePresenter

  val recyclerView by lazy { view?.findViewById(R.id.recycler_view) as RecyclerView }

  override fun getLayoutId() = R.layout.fragment_genre

  override fun onCreate(savedInstanceState: Bundle?) {
    genreComponent()?.inject(this)
    super.onCreate(savedInstanceState)
    genrePresenter.attachView(this)
  }

  override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
//    genrePresenter.addSubGenres(arguments.getParcelableArray(Tags.SUBGENRES.name)
//        .map { it as SubGenre })
//    genrePresenter.restoreInstanceState(savedInstanceState)
  }

  override fun ready() = isAdded

  override fun renderSubGenres(subGenres: List<SubGenre>) {

  }

  override fun showEmpty() {

  }

  fun configRecyclerViewLayoutManger() {
    val resources = getContext().getResources()
    val  layoutManager = if (resources.getBoolean(R.bool.tablet))
     GridLayoutManager(getContext(), resources.getInteger(R.integer.recycler_view_column))
    else LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layoutManager)
  }

  fun genreComponent(): GenreComponent? {
    if (genreComponent == null) {
      genreComponent = DaggerGenreComponent.builder()
          .genreModule(GenreModule())
          .build()
    }
    return genreComponent
  }

}