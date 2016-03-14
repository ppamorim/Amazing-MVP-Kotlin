package com.amazingmvpkotlin.di.components

import com.amazingmvpkotlin.di.HomeModule
import com.amazingmvpkotlin.ui.activity.HomeActivity
import com.github.ppamorim.amazingmvpkotlinrules.presenter.HomePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(HomeModule::class))
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
    fun homePresenter(): HomePresenter
}