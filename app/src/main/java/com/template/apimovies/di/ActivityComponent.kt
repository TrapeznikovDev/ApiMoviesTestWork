package com.template.apimovies.di

import com.template.apimovies.di.retrofit.Api
import com.template.apimovies.activities.main.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, ViewModelModule::class])
interface ActivityComponent {


    fun api(): Api
    fun inject(activity: MainActivity)
}