package com.android.developer.news.presentation.di.module

import com.android.developer.news.domain.interactor.TopUsNewsInteractor
import com.android.developer.news.presentation.mvp.presenter.PresenterNews
import dagger.Module
import dagger.Provides

@Module(includes = [InteractorModule::class])
class PresenterModule {

    @Provides
    fun providePresenter(interactor: TopUsNewsInteractor): PresenterNews {
        return PresenterNews(interactor)
    }
}