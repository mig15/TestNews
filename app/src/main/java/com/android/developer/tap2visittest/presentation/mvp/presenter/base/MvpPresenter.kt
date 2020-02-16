package com.android.developer.tap2visittest.presentation.mvp.presenter.base

import com.android.developer.tap2visittest.presentation.mvp.view.base.MvpView

interface MvpPresenter<V : MvpView> {

    fun attachView(v: V)
    fun viewReady()
    fun detachView()
}