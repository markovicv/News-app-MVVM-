package com.example.news.presentation.contract

import androidx.lifecycle.LiveData
import com.example.news.Resource
import com.example.news.data.model.api_response.Article
import com.example.news.data.model.api_response.NewsResponse
import com.example.news.data.model.domain.ArticleDomain
import kotlinx.coroutines.Job

interface ArticleContract {
    interface ViewModel{
        val topHeadLinesNews:LiveData<Resource<NewsResponse>>
        val sportNews:LiveData<Resource<NewsResponse>>
        val scienceNews:LiveData<Resource<NewsResponse>>
        val searchedNews:LiveData<Resource<NewsResponse>>
        val healthNews:LiveData<Resource<NewsResponse>>
        val technologyNews:LiveData<Resource<NewsResponse>>
        var topHeadLineNumber:Int
        fun getTopHeadLineNews(countryCode:String):Job
        fun getSportsNews(countryCode: String,category:String):Job
        fun getScienceNews(countryCode: String,category: String):Job
        fun getHealthNews(countryCode: String,category: String):Job
        fun getTechnologyNews(countryCode: String,category: String):Job
        fun getSearchedNews(searchQuery:String):Job
        fun saveArticle(article:Article):Job
        fun getSavedNews():LiveData<List<Article>>
        fun deleteArticle(article: Article):Job
    }
}