package com.template.apimovies.activities.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.example.Results
import com.example.newkrepysh.di.retrofit.Api
import com.template.apimovies.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    val api:Api
): ViewModel() {
    private suspend fun req() = api.getData(BuildConfig.API_KEY)
    var mData = MutableLiveData<List<Results>>()
    var mProgress = MutableLiveData(LoadingState.initial)
    init {
        viewModelScope.launch(Dispatchers.IO) {
            mProgress.postValue(LoadingState.isLoading)
            mData.postValue(req().body()?.results)
            mProgress.postValue(LoadingState.initial)
        }
    }
}
enum class LoadingState {
    isLoading, initial
}