package com.android.developer.tap2visittest.presentation.mvp.view.base

import com.android.developer.tap2visittest.presentation.list.items.AdapterItem

interface NewsMvp : MvpView {

    fun showNews(list: List<AdapterItem>)
    fun showAlert(title: String, msg: String)
    fun loading(loading: Boolean)
    fun addNews(list: List<AdapterItem>)
    fun openDetail(url: String)
}