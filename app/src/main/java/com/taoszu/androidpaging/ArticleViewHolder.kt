/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.taoszu.androidpaging

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.taoszu.androidpaging.entity.ArticleEntity
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple ViewHolder that can bind a Cheese item. It also accepts null items since the data may
 * not have been fetched before it is bound.
 */
class ArticleViewHolder(parent :ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycle_article_item, parent, false)) {

    private val titleView = itemView.findViewById<TextView>(R.id.value_title)
    private val authorView = itemView.findViewById<TextView>(R.id.value_author)
    private val timeView = itemView.findViewById<TextView>(R.id.value_time)
    private val typeView = itemView.findViewById<TextView>(R.id.value_type)
    var article : ArticleEntity? = null

    /**
     * Items might be null if they are not paged in yet. PagedListAdapter will re-bind the
     * ViewHolder when Item is loaded.
     */
    fun bindTo(article : ArticleEntity?) {
        this.article = article
        titleView.text = article?.title
        authorView.text = article?.author
        article?.timeStamp?.let {
            timeView.text = SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINESE).format(Date(it))
        }
        typeView.text = article?.type
    }
}