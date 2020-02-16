package com.android.developer.tap2visittest.presentation.di.module

import com.android.developer.tap2visittest.domain.interactor.TopUsNewsInteractor
import com.android.developer.tap2visittest.presentation.mvp.presenter.PresenterNews
import dagger.Module
import dagger.Provides

@Module(includes = [InteractorModule::class])
class PresenterModule {

    @Provides
    fun providePresenter(interactor: TopUsNewsInteractor): PresenterNews {
        return PresenterNews(interactor)
    }
}