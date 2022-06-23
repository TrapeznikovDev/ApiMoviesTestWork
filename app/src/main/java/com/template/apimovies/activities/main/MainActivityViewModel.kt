package com.template.apimovies.activities.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.template.apimovies.data.Results
import com.template.apimovies.di.retrofit.Api
import com.template.apimovies.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    val api: Api
): ViewModel() {
    private suspend fun requestData() = api.getData(BuildConfig.API_KEY)
    var mData = MutableLiveData<List<Results>?>()
    var mProgress = MutableLiveData(LoadingState.initial)
    init {
        viewModelScope.launch(Dispatchers.IO) {
            mProgress.postValue(LoadingState.isLoading)
            val response = requestData()
            if(response?.code()==200){
                mData.postValue(response.body()?.results)
                mProgress.postValue(LoadingState.initial)

            }else{
                mProgress.postValue(LoadingState.error)
            }
        }
    }
}
enum class LoadingState {
    isLoading, initial, error
}