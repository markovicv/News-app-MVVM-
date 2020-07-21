package com.example.news.data.repository

import com.example.news.data.database.ArticleDao
import com.example.news.data.model.api_response.NewsResponse
import com.example.news.data.model.domain.ArticleDomain
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
        val sportNewsResponse = remoteSource.fetchSportsNews(countryCode,category,pages,key)
        return sportNewsResponse
    }
}