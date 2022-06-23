package com.template.apimovies

import android.app.Activity
import android.app.Application
import com.template.apimovies.di.*

class ComponentManager {

    lateinit var appComponent: AppComponent

    private val activityComponentMap = HashMap<String, ActivityComponent>()

    fun init(application: Application){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .retrofitModule(RetrofitModule(application.applicationContext))
            .build()

        appComponent.inject(application as MainApplication)
    }

    fun getActivityComponent(activity: Activity): ActivityComponent{
        val key = getKey(activity)
        val activityComponent: ActivityComponent?
        activityComponent = createNewActivityComponent(activity)
        activityComponentMap[key] = activityComponent
        return activityComponent
    }


    private fun createNewActivityComponent(activity: Activity): ActivityComponent{
        return DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(ActivityModule(activity))
            .build()
    }

    private fun getKey(activity: Activity): String {
        return activity.localClassName
    }

    private object Holder {
        val INSTANCE = ComponentManager()
    }

    companion object{
        val instance: ComponentManager by lazy { Holder.INSTANCE }
    }
}