package com.android.developer.tap2visittest.domain.interactor.base

import io.reactivex.observers.DisposableObserver

abstract class DefaultObserver<T> : DisposableObserver<T>()