package com.android.developer.tap2visittest.data.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder {

    private val baseUrl = "https://newsapi.org/v2/"
    private val apiKey = "194ea0af1aee47b5b163ecefc8c38738"

    val serverApi: RestApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getInterceptor())
            .build()

        serverApi = retrofit.create(RestApi::class.java)
    }

    private fun getInterceptor(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.connectTimeout(20, TimeUnit.SECONDS)
        client.readTimeout(20, TimeUnit.SECONDS)
        client.interceptors().add(Interceptor { chain ->
            val original = chain.request()

            val originalHttpUrl = original
                .url()
                .newBuilder()
                .addQueryParameter("apiKey", apiKey)

            val request = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .url(originalHttpUrl.build())
                .method(original.method(), original.body())
                .build()

            chain.proceed(request)
        })

        return client.build()
    }
}