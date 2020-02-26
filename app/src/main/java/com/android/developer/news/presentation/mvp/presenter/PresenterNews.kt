package com.android.developer.news.presentation.mvp.presenter

import com.android.developer.news.domain.entity.MappingResponse
import com.android.developer.news.domain.interactor.TopUsNewsInteractor
import com.android.developer.news.domain.interactor.base.DefaultObserver
import com.android.developer.news.presentation.mvp.presenter.base.BasePresenter
import com.android.developer.news.presentation.mvp.view.base.NewsMvp

class PresenterNews(private val case: TopUsNewsInteractor) : BasePresenter<NewsMvp>() {

    private var totalNews = 0
    private var page = 1
    private var gettingCount = 0
    private var wasRequest = false
    private var selectCategory: String? = null

    override fun viewReady() {
        getNews(null)
    }

    fun reset() {
        totalNews = 0
        page = 1
        gettingCount = 0
    }

    fun pagination() {
        if (wasRequest || gettingCount >= totalNews) {
            return
        }
        getNews(selectCategory)
    }

    fun getNews(category: String?) {
        selectCategory = category
        case.execute(NewsObserver(), TopUsNewsInteractor.Data.setData(page, category))
        getView()?.loading(true)
        wasRequest = true
    }

    fun unsubscribe() {
        case.dispose()
    }

    private inner class NewsObserver : DefaultObserver<MappingResponse>() {

        override fun onComplete() {
            wasRequest = false
        }

        override fun onNext(t: MappingResponse) {
            getView()?.loading(false)

            val pagination = totalNews == 0

            totalNews = t.total
            gettingCount += t.list.size
            page++

            setClick(t.list)

            if (pagination)
                getView()?.showNews(t.list)
            else
                getView()?.addNews(t.list)
        }

        override fun onError(e: Throwable) {
            wasRequest = false
            getView()?.loading(false)
            getView()?.showAlert(title = "Error", msg = e.toString())
        }
    }

    private fun setClick(list: List<MappingResponse.MappingNews>) {
        list.forEach {
            it.onClick = { url ->
                getView()?.openDetail(url)
            }
        }
    }
}