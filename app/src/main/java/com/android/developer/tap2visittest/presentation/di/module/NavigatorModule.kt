package com.android.developer.tap2visittest.presentation.di.module

import com.android.developer.tap2visittest.presentation.navigation.FragmentNavigator
import dagger.Module
import dagger.Provides

@Module
class NavigatorModule {

    @Provides
    fun provideNavigator(): FragmentNavigator {
        return FragmentNavigator()
    }
}