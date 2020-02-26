package com.android.developer.news.domain.repository

import com.android.developer.news.data.entity.response.ResponseTopUsNews
import io.reactivex.Observable

interface Repository {

    fun getTopUsNews(page: Int): Observable<ResponseTopUsNews>
    fun getTopUsNewsForCategory(category: String, page: Int): Observable<ResponseTopUsNews>
}