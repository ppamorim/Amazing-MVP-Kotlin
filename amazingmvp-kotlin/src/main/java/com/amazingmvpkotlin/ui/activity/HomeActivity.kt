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
package com.amazingmvpkotlin.ui.activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.amazingmvpkotlin.AmazingMvpApplication
import com.amazingmvpkotlin.R
import com.amazingmvpkotlin.di.HomeModule
import com.amazingmvpkotlin.di.components.DaggerHomeComponent
import com.amazingmvpkotlin.di.components.HomeComponent
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.presenter.HomePresenter
import javax.inject.Inject

class HomeActivity : AbstractActivity(), HomePresenter.HomeView {

  var homeComponent: HomeComponent? = null

  //With or without companion, this return null after the creation of component
  companion object {
    @JvmStatic @Inject lateinit var homePresenter: HomePresenter
  }

  val toolbar by lazy { findViewById(R.id.toolbar) as Toolbar }
  val viewPager by lazy { findViewById(R.id.view_pager) as ViewPager }
  val progressBar by lazy { findViewById(R.id.progress_bar) as ProgressBar }
  val warning by lazy { findViewById(R.id.text_view_warning) as TextView }
  val tryAgain by lazy { findViewById(R.id.try_again) as Button }

  override fun getLayoutId() = R.layout.activity_home

  override fun onCreate(savedInstanceState: Bundle?) {
    homeComponent()?.inject(this)
    super.onCreate(savedInstanceState)
  }

  override fun onPostCreate(savedInstanceState: Bundle?) {
    super.onPostCreate(savedInstanceState)
    setSupportActionBar(toolbar)
    println(homePresenter)
  }

  override fun ready(): Boolean = !isFinishing

  override fun renderGenres(subGenres: MutableList<Genre>) {
      configViewPager(subGenres);
    viewPager.visibility = View.VISIBLE
    progressBar.visibility = View.GONE
    warning.visibility = View.GONE
    tryAgain.visibility = View.GONE
  }

  override fun showLoading() {
    viewPager.visibility = View.GONE
    progressBar.visibility = View.VISIBLE
    warning.visibility = View.GONE
    tryAgain.visibility = View.GONE
  }

  override fun showError() {
    showWarningView(R.string.connection_error)
  }

  override fun showEmpty() {
    showWarningView(R.string.empty)
  }

  override fun showOffline(reason: Int) {
    Snackbar.make(findViewById(R.id.container) as Toolbar,
            R.string.connection_error, Snackbar.LENGTH_LONG).show()
  }

  fun showWarningView(errorCode: Int) {
    warning.setText(errorCode)
    viewPager.visibility = View.GONE
    progressBar.visibility = View.GONE
    warning.visibility = View.VISIBLE
    tryAgain.visibility = View.VISIBLE
  }

  fun configViewPager(subGenres: MutableList<Genre>) {
//  viewPager.setAdapter(GenreAdapter(getSupportFragmentManager(), subGenres))
  }

  fun homeComponent(): HomeComponent? {
    if (homeComponent == null) {
      homeComponent = DaggerHomeComponent.builder()
          .applicationComponent((application as AmazingMvpApplication).applicationComponent)
          .homeModule(HomeModule())
          .build()
    }
    return homeComponent
  }

}