package com.template.apimovies.di

import com.example.newkrepysh.di.retrofit.Api
import com.template.apimovies.activities.main.MainActivity
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, ViewModelModule::class])
interface ActivityComponent {


    fun api(): Api
    fun inject(activity: MainActivity)
}