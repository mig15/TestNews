package com.android.developer.news.presentation.list.adapter

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.developer.news.presentation.list.items.AdapterItem
import com.android.developer.news.presentation.list.renderer.ViewRenderer

class SingleRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data: MutableList<AdapterItem> = arrayListOf()

    private val rendererArray = SparseArray<ViewRenderer<AdapterItem, RecyclerView.ViewHolder>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return rendererArray[viewType].createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        rendererArray[item.getType()].bindView(item, holder, holder.adapterPosition)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getType()
    }

    fun <M : AdapterItem, VH : RecyclerView.ViewHolder> registerRenderer(renderer: ViewRenderer<M, VH>) {
        renderer as ViewRenderer<AdapterItem, RecyclerView.ViewHolder>
        rendererArray.put(renderer.getType(), renderer)
    }

    fun getData() = data

    fun notifyData(list: List<AdapterItem>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int) = data[position]
}