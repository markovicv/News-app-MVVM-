package com.example.news.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news.data.model.entities.ArticleEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article:ArticleEntity)

    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<ArticleEntity>>

    @Delete
    suspend fun delete(article: ArticleEntity)
}