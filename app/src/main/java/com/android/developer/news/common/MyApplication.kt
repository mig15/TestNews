package com.android.developer.news.common

import android.app.Application
import com.android.developer.news.presentation.di.component.ActivityComponent
import com.android.developer.news.presentation.di.component.DaggerActivityComponent

class MyApplication : Application() {

    companion object {
        lateinit var component: ActivityComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerActivityComponent.create()
    }
}