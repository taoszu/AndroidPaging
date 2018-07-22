package com.taoszu.androidpaging.view

import android.arch.lifecycle.Observer
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.taoszu.androidpaging.ArticlePageAdapter
import com.taoszu.androidpaging.R
import com.taoszu.androidpaging.datasource.LocalDataSourceFactory
import com.taoszu.androidpaging.datasource.NetWorkDataSourceFactory
import kotlinx.android.synthetic.main.act_local_data_paging.*

/**
 * Created by 阿涛 on 2018/7/22.
 */
class NetWorkDataPagingActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_network_data_paging)

        val pageAdapter = ArticlePageAdapter()
        recycle_article.adapter = pageAdapter
        recycle_article.layoutManager = LinearLayoutManager(this)

        val pagedListConfig = PagedList.Config.Builder().
                setEnablePlaceholders(true)
                .setPageSize(10).setInitialLoadSizeHint(20).
                        build()
        var postList = LivePagedListBuilder(NetWorkDataSourceFactory(), pagedListConfig).build()
        postList.observe(this, Observer {
            pageAdapter.submitList(it)
        })
    }
}