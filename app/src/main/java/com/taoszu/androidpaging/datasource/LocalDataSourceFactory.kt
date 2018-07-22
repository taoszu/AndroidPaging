package com.taoszu.androidpaging.datasource

import android.arch.paging.DataSource
import android.arch.paging.PositionalDataSource
import android.util.Log
import com.taoszu.androidpaging.entity.ArticleEntity

/**
 * Created by 阿涛 on 2018/7/15.
 */
class LocalDataSourceFactory:DataSource.Factory<Int, ArticleEntity>() {
    override fun create(): DataSource<Int, ArticleEntity> {
        return localDataSource
    }

    companion object {
        val localDataSource = object : PositionalDataSource<ArticleEntity>() {
            private fun computeCount(): Int {
                return 10000
            }
            private fun loadRangeInternal(startPosition: Int, loadCount: Int): List<ArticleEntity> {
                val articleList = mutableListOf<ArticleEntity>()
                val authorPrefix = "作者"
                val titlePrefix = "我是一个标题"
                val typePrefix = "类别"
                val timeStampBase = 1531548138000L
                for (i in 0 until loadCount) {
                    var articleEntity = ArticleEntity()
                    articleEntity.id = (startPosition + i).toString()
                    articleEntity.author = "$authorPrefix ${articleEntity.id}"
                    articleEntity.title = "$titlePrefix ${articleEntity.id}"
                    articleEntity.type = "$typePrefix ${articleEntity.id}"
                    articleEntity.timeStamp = timeStampBase + i * 1000L
                    articleList.add(articleEntity)
                }
                return articleList
            }

            override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ArticleEntity>) {
                Log.e("LoadRange", "range" + params.startPosition)
                callback.onResult(loadRangeInternal(params.startPosition, params.loadSize))
            }

            override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ArticleEntity>) {
                val totalCount = computeCount()
                val position = PositionalDataSource.computeInitialLoadPosition(params, totalCount)
                val loadSize = PositionalDataSource.computeInitialLoadSize(params, position, totalCount)
                callback.onResult(loadRangeInternal(position, loadSize), position, totalCount)
            }
        }
    }

}