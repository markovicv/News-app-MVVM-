package com.example.news.data.model.domain

data class ArticleDomain( val source: String,
                          val author:String,
                          val title:String,
                          val description:String,
                          val url:String,
                          val urlToImage:String,
                          val publishedAt:String,
                          val content:String) {
}