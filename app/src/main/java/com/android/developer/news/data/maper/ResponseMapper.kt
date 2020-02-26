package com.android.developer.news.data.maper

import com.android.developer.news.data.entity.response.ResponseTopUsNews
import com.android.developer.news.domain.entity.MappingResponse

class ResponseMapper {

    fun transform(response: ResponseTopUsNews): MappingResponse {
        return MappingResponse(total = response.totalResults).apply {
            list = response.articles.map {
                MappingResponse.MappingNews(
                    idSource = -1,
                    sourceName = it.source.name ?: "Источник неизвестен",
                    author = it.author ?: "Автор неизвестен",
                    title = it.title ?: "Какая-то новость",
                    description = it.description ?: "",
                    urlToImage = it.urlToImage ?: "",
                    date = it.publishedAt ?: "",
                    detailUrl = it.detailUrl ?: "https://www.vesti.ru/")
            }
        }
    }
}