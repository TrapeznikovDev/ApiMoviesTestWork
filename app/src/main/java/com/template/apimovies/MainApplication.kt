package com.template.apimovies

import android.app.Application

class MainApplication: Application() {


    override fun onCreate() {
        super.onCreate()
       ComponentManager.instance.init(this)
    }

}