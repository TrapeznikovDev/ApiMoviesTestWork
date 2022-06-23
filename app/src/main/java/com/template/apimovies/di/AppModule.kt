package com.template.apimovies.di

import android.app.Application
import android.content.Context

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @AppContext
    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }


}