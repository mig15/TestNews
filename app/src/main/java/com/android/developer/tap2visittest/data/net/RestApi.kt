package com.android.developer.tap2visittest.data.net

import com.android.developer.tap2visittest.data.entity.response.ResponseTopUsNews
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("top-headlines")
    fun requestTopUsNews(@Query("country") country: String,
                         @Query("page") page: Int): Observable<ResponseTopUsNews>

    @GET("top-headlines")
    fun requestTopUsNewsForCategory(@Query("country") country: String,
                                    @Query("category") category: String,
                                    @Query("page") page: Int): Observable<ResponseTopUsNews>
}