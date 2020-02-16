package com.android.developer.tap2visittest.common

import android.app.Application
import com.android.developer.tap2visittest.presentation.di.component.ActivityComponent
import com.android.developer.tap2visittest.presentation.di.component.DaggerActivityComponent

class MyApplication : Application() {

    companion object {
        lateinit var component: ActivityComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerActivityComponent.create()
    }
}