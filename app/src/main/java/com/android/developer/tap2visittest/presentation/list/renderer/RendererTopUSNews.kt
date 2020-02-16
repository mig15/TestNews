package com.android.developer.tap2visittest.presentation.list.renderer

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.developer.tap2visittest.R
import com.android.developer.tap2visittest.domain.entity.MappingResponse
import com.android.developer.tap2visittest.presentation.list.vh.TopUsNewsVH
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class RendererTopUSNews : ViewRenderer<MappingResponse.MappingNews, TopUsNewsVH>() {

    private lateinit var context: Context

    override fun getType(): Int {
        return 0
    }

    override fun createViewHolder(parent: ViewGroup): TopUsNewsVH {
        context = parent.context
        return TopUsNewsVH(LayoutInflater.from(parent.context).inflate(R.layout.item_top_us_news, parent, false))
    }

    override fun bindView(model: MappingResponse.MappingNews, holder: TopUsNewsVH, position: Int) {
        holder.tvSource.text = model.sourceName
        holder.tvAuthor.text = model.author
        holder.tvDate.text = model.date
        holder.tvTitle.text = model.title
        holder.tvNews.text = model.description
        holder.itemView.setOnClickListener { model.onClick?.invoke(model.detailUrl) }

        if (model.urlToImage.isNotEmpty()) {
            Picasso
                .with(context)
                .load(model.urlToImage)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(holder.ivImage)
        }
    }
}