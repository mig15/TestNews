package com.android.developer.news.domain.interactor

import com.android.developer.news.data.maper.ResponseMapper
import com.android.developer.news.domain.entity.MappingResponse
import com.android.developer.news.domain.interactor.base.UseCase
import com.android.developer.news.domain.repository.Repository
import io.reactivex.Observable

class TopUsNewsInteractor(private val repository: Repository) : UseCase<MappingResponse, TopUsNewsInteractor.Data>() {

    private val mapper = ResponseMapper()

    override fun buildUseCaseObservable(params: Data): Observable<MappingResponse> {
        return when {
            params.category == null -> repository.getTopUsNews(params.page).map { mapper.transform(it) }
            else -> repository.getTopUsNewsForCategory(params.category, params.page).map { mapper.transform(it) }
        }
    }

    class Data(val page: Int, val category: String? = null) {
        companion object {
            fun setData(page: Int, category: String?) = Data(page, category)
        }
    }
}