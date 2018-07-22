package com.taoszu.androidpaging.datasource

import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PositionalDataSource
import android.util.Log
import com.taoszu.androidpaging.entity.ArticleEntity

/**
 * Created by 阿涛 on 2018/7/22
 */
class NetWorkDataSourceFactory:DataSource.Factory<Int, ArticleEntity>() {
    override fun create(): DataSource<Int, ArticleEntity> {
        return localDataSource
    }

    companion object {
        val localDataSource = object : PageKeyedDataSource<Int, ArticleEntity>() {
            override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ArticleEntity>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleEntity>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ArticleEntity>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }
}