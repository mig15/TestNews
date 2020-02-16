package com.android.developer.tap2visittest.presentation.di.component

import com.android.developer.tap2visittest.presentation.di.module.NavigatorModule
import com.android.developer.tap2visittest.presentation.di.module.PresenterModule
import com.android.developer.tap2visittest.presentation.mvp.presenter.PresenterNews
import com.android.developer.tap2visittest.presentation.navigation.FragmentNavigator
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigatorModule::class, PresenterModule::class])
interface ActivityComponent {

    fun getNavigator(): FragmentNavigator
    fun getPresenter(): PresenterNews
}