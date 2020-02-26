package com.android.developer.news.data.entity.response

data class ResponseTopUsNews(val status: String,
                             val totalResults: Int,
                             val articles: List<Article>) {

    data class Article(val author: String?,
                       val title: String?,
                       val description: String?,
                       val urlToImage: String?,
                       val publishedAt: String?,
                       val source: Source,
                       val detailUrl: String?) {

        data class Source(val name: String?)
    }
}