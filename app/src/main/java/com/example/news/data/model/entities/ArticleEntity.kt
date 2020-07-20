package com.example.news.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.news.data.model.api_response.Source


@Entity(
    tableName = "articles"
)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val source: String,
    val author:String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String,
    val publishedAt:String,
    val content:String
) {
}