package com.amazingmvpkotlin.di

import android.app.Application
import android.content.Context
import com.amazingmvpkotlin.di.scopes.ActivityScope
import com.github.ppamorim.threadexecutor.InteractorExecutor
import com.github.ppamorim.threadexecutor.MainThread
import com.github.ppamorim.threadexecutor.MainThreadImpl
import com.github.ppamorim.threadexecutor.ThreadExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule(private val application: Application) {

    @Provides @Singleton @ActivityScope fun provideApplicationContext(): Context {
        return application
    }

    @Provides @Singleton fun provideThreadExecutor(executor: ThreadExecutor) : InteractorExecutor {
        return executor
    }

    @Provides @Singleton fun providePostExecutionThread(mainThread: MainThreadImpl): MainThread {
        return mainThread
    }

}