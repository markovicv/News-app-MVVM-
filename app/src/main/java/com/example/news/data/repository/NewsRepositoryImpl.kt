package com.example.news.data.repository

import androidx.lifecycle.LiveData
import com.example.news.data.database.ArticleDao
import com.example.news.data.model.api_response.Article
import com.example.news.data.model.api_response.NewsResponse
import com.example.news.data.service.NewsAPI
import retrofit2.Response

class NewsRepositoryImpl(val remoteSource:NewsAPI,val localSource:ArticleDao) : NewsRepository{

    override suspend fun getTopHeadLines(
        countryCode: String,
        pages: Int,
        key: String
    ): Response<NewsResponse> {
        val articleResponse = remoteSource.fetchTopHeadlines(countryCode,pages,key)
        return articleResponse


    }

    override suspend fun getForCategory(
        countryCode: String,
        category: String,
        pages: Int,
        key: String
    ): Response<NewsResponse> {
        val sportNewsResponse = remoteSource.fetchCategoryNews(countryCode,category,pages,key)
        return sportNewsResponse
    }

    override suspend fun getSearchedNews(
        searchQuery: String,
        pages: Int,
        key: String
    ): Response<NewsResponse> {
        val searhcedNewsResponse = remoteSource.fetchSearchedNews(searchQuery,pages,key)
        return searhcedNewsResponse
    }

    override suspend fun upsert(article: Article) {
        localSource.upsert(article)

    }

    override suspend fun delete(article: Article) {
        localSource.delete(article)
    }

    override fun getAllArticleFromDb(): LiveData<List<Article>> {
        val listArticles = localSource.getAllArticles()
        return listArticles
    }
}