package com.android.developer.news.presentation.list.renderer

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.developer.news.presentation.list.items.AdapterItem

abstract class ViewRenderer<M : AdapterItem, VH : RecyclerView.ViewHolder> {

    abstract fun getType(): Int

    abstract fun createViewHolder(parent: ViewGroup): VH

    abstract fun bindView(model: M, holder: VH, position: Int)
}