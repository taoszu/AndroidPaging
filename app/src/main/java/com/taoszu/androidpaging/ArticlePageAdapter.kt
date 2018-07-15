package com.taoszu.androidpaging

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.taoszu.androidpaging.entity.ArticleEntity

class ArticlePageAdapter : PagedListAdapter<ArticleEntity, ArticleViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
            ArticleViewHolder(parent)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ArticleEntity>() {
            override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean =
                    oldItem == newItem
        }
    }
}
