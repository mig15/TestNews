package com.android.developer.news.presentation.mvp.presenter.base

import com.android.developer.news.presentation.mvp.view.base.MvpView

abstract class BasePresenter<V : MvpView> : MvpPresenter<V> {

    private var view: V? = null

    override fun attachView(v: V) {
        view = v
    }

    override fun detachView() {
        view = null
    }

    fun getView() = view
}