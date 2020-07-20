package com.example.news.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news.data.model.entities.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ArticleDatabase :RoomDatabase(){
    abstract fun getArticleDao():ArticleDao
}