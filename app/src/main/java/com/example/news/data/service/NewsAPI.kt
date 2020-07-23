package com.example.news.data.service

import com.example.news.data.model.api_response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun fetchTopHeadlines(
        @Query("country") countryCode:String = "us",
        @Query("pageSize") pages:Int = 20,
        @Query("apiKey") apiKey:String
    ):Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun fetchCategoryNews(
        @Query("country") conuntryCode:String = "us",
        @Query("category") category: String,
        @Query("pageSize") pages:Int = 20,
        @Query("apiKey")apiKey: String
    ):Response<NewsResponse>


    @GET("v2/top-headlines")
    suspend fun fetchSearchedNews(
        @Query("q") querySearch:String,
        @Query("pageSize") pages:Int =20,
        @Query("apiKey") apiKey: String
    ):Response<NewsResponse>


}