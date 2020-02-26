package com.android.developer.news.presentation.di.module

import com.android.developer.news.presentation.navigation.FragmentNavigator
import dagger.Module
import dagger.Provides

@Module
class NavigatorModule {

    @Provides
    fun provideNavigator(): FragmentNavigator {
        return FragmentNavigator()
    }
}