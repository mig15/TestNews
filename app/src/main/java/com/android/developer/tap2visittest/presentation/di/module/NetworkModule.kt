package com.android.developer.tap2visittest.presentation.di.module

import com.android.developer.tap2visittest.data.net.RetrofitBuilder
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