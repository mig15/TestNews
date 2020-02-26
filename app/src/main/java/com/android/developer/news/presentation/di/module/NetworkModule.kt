package com.android.developer.news.presentation.di.module

import com.android.developer.news.data.net.RetrofitBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideNetwork(): RetrofitBuilder {
        return RetrofitBuilder()
    }
}