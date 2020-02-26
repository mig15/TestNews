package com.android.developer.news.presentation.mvp.presenter.base

import com.android.developer.news.presentation.mvp.view.base.MvpView

interface MvpPresenter<V : MvpView> {

    fun attachView(v: V)
    fun viewReady()
    fun detachView()
}