package com.amazingmvpkotlin

import android.app.Application
import com.amazingmvpkotlin.di.ApplicationModule
import com.amazingmvpkotlin.di.components.ApplicationComponent

class MVPApplication : Application() {

    companion object {
        @JvmStatic lateinit var applicationComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
    }

    fun applicationComponent(): ApplicationComponent? {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(this))
                    .build()
        }
        return applicationComponent
    }

}