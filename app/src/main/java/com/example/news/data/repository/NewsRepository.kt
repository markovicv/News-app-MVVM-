package com.example.news.data.repository

import androidx.lifecycle.LiveData
import com.example.news.data.model.api_response.Article
import com.example.news.data.model.api_response.NewsResponse
import retrofit2.Response

interface NewsRepository {

    suspend fun getTopHeadLines(countryCode:String,pages:Int,key:String):Response<NewsResponse>
    suspend fun getForCategory(countryCode: String,category:String,pages: Int,key:String):Response<NewsResponse>
    suspend fun getSearchedNews(searchQuery:String,pages:Int,key:String):Response<NewsResponse>
    suspend fun upsert(article:Article)
    suspend fun delete(article: Article)
    fun getAllArticleFromDb():LiveData<List<Article>>

}