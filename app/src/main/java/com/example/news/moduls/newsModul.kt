package com.example.news.moduls

import com.example.news.data.database.ArticleDatabase
import com.example.news.data.repository.NewsRepository
import com.example.news.data.repository.NewsRepositoryImpl
import com.example.news.data.service.NewsAPI
import com.example.news.presentation.viewmodel.ArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModul = module {
    viewModel {
        ArticleViewModel(get())
    }
    single<NewsRepository>{
        NewsRepositoryImpl(remoteSource = get(),localSource = get())
    }
    single{
        get<ArticleDatabase>().getArticleDao()
    }
    single<NewsAPI>{
        create(get())
    }
}