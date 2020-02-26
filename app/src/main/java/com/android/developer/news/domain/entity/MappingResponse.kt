package com.android.developer.news.domain.entity

import com.android.developer.news.presentation.list.items.AdapterItem

data class MappingResponse(val total: Int,
                           var list: List<MappingNews> = arrayListOf()) {

    data class MappingNews(val idSource: Int,
                           val sourceName: String,
                           val author: String,
                           val title: String,
                           val description: String,
                           val urlToImage: String,
                           val date: String,
                           val detailUrl: String) : AdapterItem {

        var onClick: ((url: String) -> Unit)? = null

        override fun getType(): Int {
            return 0
        }
    }
}