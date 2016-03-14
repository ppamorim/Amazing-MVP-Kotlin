package com.amazingmvpkotlin

import android.app.Application
import com.amazingmvpkotlin.di.ApplicationModule
import com.amazingmvpkotlin.di.components.ApplicationComponent
import com.amazingmvpkotlin.di.components.DaggerApplicationComponent

class MVPApplication : Application() {

    companion object {
        @JvmStatic lateinit var applicationComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        initializeDependencyInjector()!!.inject(this)
        super.onCreate()
    }

    fun initializeDependencyInjector(): ApplicationComponent? {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(this))
                    .build()
        }
        return applicationComponent
    }

    fun applicationComponent(): ApplicationComponent? {
        return applicationComponent
    }

}