package com.template.apimovies.di

import androidx.lifecycle.ViewModel
import com.template.apimovies.activities.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun mainActivityModel(mainActivityModel: MainActivityViewModel): ViewModel


}