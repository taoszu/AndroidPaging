package com.taoszu.androidpaging.db

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.taoszu.androidpaging.entity.ArticleEntity

/**
 * Created by 阿涛 on 2018/7/14.
 */
@Dao
interface ArticleDao {
    @Query ("SELECT * FROM article")
    fun getAll(): List<ArticleEntity>

    @Query ("SELECT * FROM article")
    fun getAllByDataSource(): DataSource.Factory<Int, ArticleEntity>


    @Insert
    fun insertAll(articleLists: List<ArticleEntity>)

    @Delete
    fun deleteAll(articleLists: List<ArticleEntity>)
}