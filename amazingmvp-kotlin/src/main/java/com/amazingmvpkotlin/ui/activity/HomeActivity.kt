package com.amazingmvpkotlin.ui.activity

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.amazingmvpkotlin.R
import com.amazingmvpkotlin.di.components.HomeComponent
import com.amazingmvpkotlin.ui.adapter.GenreAdapter
import com.github.ppamorim.amazingmvpkotlinrules.domain.model.Genre
import com.github.ppamorim.amazingmvpkotlinrules.presenter.HomePresenter
import javax.inject.Inject

class HomeActivity : AbstractActivity(), HomePresenter.View {

    var homeComponent: HomeComponent? = null

    @Inject lateinit var homePresenter: HomePresenter

    val toolbar by lazy { findViewById(R.id.toolbar) as Toolbar }
    val viewPager by lazy { findViewById(R.id.view_pager) as ViewPager }
    val progressBar by lazy { findViewById(R.id.progress_bar) as ProgressBar }
    val warning by lazy { findViewById(R.id.text_view_warning) as TextView }
    val tryAgain by lazy { findViewById(R.id.try_again) as Button }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        homeComponent()!!.inject(this)
        super<AbstractActivity>.onCreate(savedInstanceState)
        homePresenter.setViewInterface(this)
        homePresenter.requestGenres(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super<AbstractActivity>.onPostCreate(savedInstanceState)
        setSupportActionBar(toolbar)
    }

    override fun isReady(): Boolean {
       return !isFinishing()
    }

    override fun renderGenres(subGenres: MutableList<Genre>) {
        configViewPager(subGenres);
        viewPager.setVisibility(View.VISIBLE)
        progressBar.setVisibility(View.GONE)
        warning.setVisibility(View.GONE)
        tryAgain.setVisibility(View.GONE)
    }

    override fun showLoading() {
        viewPager.setVisibility(View.GONE)
        progressBar.setVisibility(View.VISIBLE)
        warning.setVisibility(View.GONE)
        tryAgain.setVisibility(View.GONE)
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
        viewPager.setVisibility(View.GONE)
        progressBar.setVisibility(View.GONE)
        warning.setVisibility(View.VISIBLE)
        tryAgain.setVisibility(View.VISIBLE)
    }

    fun configViewPager(subGenres: MutableList<Genre>) {
        viewPager.setAdapter(GenreAdapter(getSupportFragmentManager(), subGenres))
    }

    fun homeComponent(): HomeComponent? {
        if (homeComponent == null) {
            homeComponent = DaggerHomeComponent.builder()
//                    .applicationModule(ApplicationModule(this))
                    .build()
        }
        return homeComponent
    }

}