package com.example.news.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.news.data.model.api_response.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article:Article)

    @Query("SELECT * FROM articles")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun delete(article: Article)
}