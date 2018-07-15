package com.taoszu.androidpaging.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.taoszu.androidpaging.entity.ArticleEntity

/**
 * Created by 阿涛 on 2018/7/14.
 */
@Database(entities =[ArticleEntity::class], version = 1)
abstract class ArticleDatabase:RoomDatabase() {
    abstract fun articleDao():ArticleDao

    fun genArticleList(articleDao: ArticleDao): List<ArticleEntity> {
        articleDao.deleteAll(articleDao.getAll())
        val articleList = mutableListOf<ArticleEntity>()
        val authorPrefix = "作者"
        val titlePrefix = "我是一个标题"
        val typePrefix = "类别"
        val timeStampBase = 1531548138000L
        for (i in 0 until 100000) {
            var articleEntity = ArticleEntity()
            articleEntity.id = i.toString()
            articleEntity.author = "$authorPrefix ${articleEntity.id}"
            articleEntity.title = "$titlePrefix ${articleEntity.id}"
            articleEntity.type = "$typePrefix ${articleEntity.id}"
            articleEntity.timeStamp = timeStampBase + i * 1000L
            articleList.add(articleEntity)
        }
        return articleList
    }
}