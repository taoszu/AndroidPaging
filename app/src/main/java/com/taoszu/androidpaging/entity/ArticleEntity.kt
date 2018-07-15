package com.taoszu.androidpaging.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by 阿涛 on 2018/7/14.
 */
@Entity(tableName = "article")
class ArticleEntity {
    @PrimaryKey
    lateinit var id:String

    @ColumnInfo(name = "title")
    lateinit var title:String

    @ColumnInfo(name = "author")
    lateinit var author:String

    @ColumnInfo(name = "timeStamp")
    var timeStamp:Long = 0

    @ColumnInfo(name = "type")
    lateinit var type:String
}