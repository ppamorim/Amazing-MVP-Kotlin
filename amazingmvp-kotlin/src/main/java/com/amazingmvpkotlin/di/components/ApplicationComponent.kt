package com.amazingmvpkotlin.di.components

import android.app.Application
import com.amazingmvpkotlin.di.ApplicationModule
import com.github.ppamorim.threadexecutor.InteractorExecutor
import com.github.ppamorim.threadexecutor.MainThread
import dagger.Component
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(application: Application)
    fun application(): Application
    fun executor(): InteractorExecutor
    fun mainThread(): MainThread
    fun okHttpClient(): OkHttpClient
}
