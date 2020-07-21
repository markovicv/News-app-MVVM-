package com.example.news.data.repository

import com.example.news.data.model.api_response.NewsResponse
import com.example.news.data.model.domain.ArticleDomain
import retrofit2.Response

interface NewsRepository {

    suspend fun getTopHeadLines(countryCode:String,pages:Int,key:String):Response<NewsResponse>
    suspend fun getForCategory(countryCode: String,category:String,pages: Int,key:String):Response<NewsResponse>

}