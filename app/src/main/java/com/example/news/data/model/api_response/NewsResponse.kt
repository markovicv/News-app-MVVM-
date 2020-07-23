package com.example.news.data.model.api_response

data class NewsResponse(
    val status:String,
    val totalResults:Int,
    val articles:MutableList<Article>
){
}