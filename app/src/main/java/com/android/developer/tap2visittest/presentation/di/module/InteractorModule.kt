package com.android.developer.tap2visittest.presentation.di.module

import com.android.developer.tap2visittest.data.net.RetrofitBuilder
import com.android.developer.tap2visittest.data.repository.RepositoryImpl
import com.android.developer.tap2visittest.domain.interactor.TopUsNewsInteractor
import com.android.developer.tap2visittest.domain.repository.Repository
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