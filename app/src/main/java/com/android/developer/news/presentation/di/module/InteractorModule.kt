package com.android.developer.news.presentation.di.module

import com.android.developer.news.data.net.RetrofitBuilder
import com.android.developer.news.data.repository.RepositoryImpl
import com.android.developer.news.domain.interactor.TopUsNewsInteractor
import com.android.developer.news.domain.repository.Repository
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class InteractorModule {

    @Provides
    fun provideNewsInteractor(retrofitBuilder: RetrofitBuilder): TopUsNewsInteractor {
        return TopUsNewsInteractor(provideRepository(retrofitBuilder))
    }


    private fun provideRepository(retrofitBuilder: RetrofitBuilder): Repository {
        return RepositoryImpl(retrofitBuilder)
    }
}