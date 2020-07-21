package com.example.news.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.Constants
import com.example.news.Resource
import com.example.news.data.model.api_response.NewsResponse
import com.example.news.data.repository.NewsRepository
import com.example.news.presentation.contract.ArticleContract
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class ArticleViewModel(val newsRepo:NewsRepository):ViewModel(),ArticleContract.ViewModel {

    override val topHeadLinesNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    override val sportNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    override val scienceNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    override var topHeadLineNumber: Int = 1

    override fun getTopHeadLineNews(countryCode: String) = viewModelScope.launch {
        topHeadLinesNews.postValue(Resource.Loading())
        val response = newsRepo.getTopHeadLines(countryCode,topHeadLineNumber,Constants.API_KEY)

        if(response.isSuccessful){
            response.body()?.let {
                topHeadLinesNews.postValue(Resource.Success(it))
            }
        }
        else{
            topHeadLinesNews.postValue(Resource.Error(response.message()))
        }

    }

    override fun getSportsNews(countryCode: String, category: String) = viewModelScope.launch {
        sportNews.postValue(Resource.Loading())
        val response = newsRepo.getForCategory(countryCode,category,topHeadLineNumber,Constants.API_KEY)
        if(response.isSuccessful){
            response.body()?.let {
                sportNews.postValue(Resource.Success(it))
            }
        }
        else{
            sportNews.postValue(Resource.Error(response.message()))
        }

    }

    override fun getScienceNews(countryCode: String, category: String)=viewModelScope.launch {
        scienceNews.postValue(Resource.Loading())
        val response = newsRepo.getForCategory(countryCode,category,topHeadLineNumber,Constants.API_KEY)
        if (response.isSuccessful){
            response.body()?.let {
                scienceNews.postValue(Resource.Success(it))
            }
        }
        else{
            scienceNews.postValue(Resource.Error(response.message()))
        }

    }
}