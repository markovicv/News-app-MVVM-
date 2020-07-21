package com.example.news.presentation.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.news.data.model.api_response.Article
import com.example.news.data.model.domain.ArticleDomain

class ArticleDiffCallBack(val oldArticleList:List<Article>,val newArticleList:List<Article>) :DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldArticleList.get(oldItemPosition).url == newArticleList.get(newItemPosition).url
    }

    override fun getOldListSize(): Int {
        return oldArticleList.size
    }

    override fun getNewListSize(): Int {
        return newArticleList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldArticle = oldArticleList.get(oldItemPosition)
        val newArticle = newArticleList.get(newItemPosition)

        return oldArticle.author == newArticle.author && oldArticle.description == newArticle.description &&
                oldArticle.content == newArticle.content

    }
}