package com.android.developer.tap2visittest.domain.repository

import com.android.developer.tap2visittest.data.entity.response.ResponseTopUsNews
import io.reactivex.Observable

interface Repository {

    fun getTopUsNews(page: Int): Observable<ResponseTopUsNews>
    fun getTopUsNewsForCategory(category: String, page: Int): Observable<ResponseTopUsNews>
}