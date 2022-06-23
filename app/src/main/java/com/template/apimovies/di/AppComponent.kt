package com.template.apimovies.di

import android.content.Context
import com.example.newkrepysh.di.retrofit.Api
import com.template.apimovies.MainApplication
import dagger.Component
import javax.inject.Singleton


    @Singleton
    @Component(modules = [AppModule::class, RetrofitModule::class,  ViewModelModule::class])

interface AppComponent {

        @AppContext
        fun context(): Context

        fun api(): Api

        fun inject(reciever: MainApplication)

}