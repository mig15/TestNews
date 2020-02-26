package com.android.developer.news.presentation.list.vh

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.developer.news.R

class TopUsNewsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvSource: TextView = itemView.findViewById(R.id.tv_source)
    val tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
    val tvDate: TextView = itemView.findViewById(R.id.tv_date)
    val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    val tvNews: TextView = itemView.findViewById(R.id.tv_news)
    val ivImage: ImageView = itemView.findViewById(R.id.iv_image)
}