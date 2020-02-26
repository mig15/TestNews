package com.android.developer.news.domain.interactor.base

import io.reactivex.observers.DisposableObserver

abstract class DefaultObserver<T> : DisposableObserver<T>()