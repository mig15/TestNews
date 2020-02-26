package com.android.developer.news.presentation.list.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addPaginationListener(manager: LinearLayoutManager, action: (() -> Unit)) {
    addOnScrollListener(object :  RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (dy > 0) {
                val visibleItemCount = manager.childCount
                val totalItemCount = manager.itemCount
                val pastVisibleItems = manager.findLastVisibleItemPosition()

                if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                    action.invoke()
                }
            }
        }
    })
}