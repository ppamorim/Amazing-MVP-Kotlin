package com.amazingmvpkotlin.di

import com.github.ppamorim.amazingmvpkotlinrules.presenter.HomePresenter
import com.github.ppamorim.amazingmvpkotlinrules.presenter.HomePresenterImpl
import dagger.Module
import dagger.Provides

@Module class HomeModule {

    @Provides fun provideHomePresenter(homePresenter: HomePresenterImpl) : HomePresenter {
        return homePresenter
    }

}