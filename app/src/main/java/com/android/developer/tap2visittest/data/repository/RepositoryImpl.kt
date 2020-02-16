package com.android.developer.tap2visittest.data.repository

import com.android.developer.tap2visittest.data.entity.response.ResponseTopUsNews
import com.android.developer.tap2visittest.data.net.RetrofitBuilder
import com.android.developer.tap2visittest.domain.repository.Repository
import io.reactivex.Observable

class RepositoryImpl(private val retrofitBuilder: RetrofitBuilder) : Repository {

    override fun getTopUsNews(page: Int): Observable<ResponseTopUsNews> {
        return retrofitBuilder.serverApi.requestTopUsNews("us", page)
    }

    override fun getTopUsNewsForCategory(category: String, page: Int): Observable<ResponseTopUsNews> {
        return retrofitBuilder.serverApi.requestTopUsNewsForCategory("us", category, page)
    }
}