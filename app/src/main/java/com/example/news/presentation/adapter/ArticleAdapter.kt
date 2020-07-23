package com.example.news.presentation.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.model.api_response.Article
import com.example.news.data.model.api_response.NewsResponse
import com.example.news.data.model.domain.ArticleDomain
import com.example.news.presentation.diff.ArticleDiffCallBack
import com.example.news.presentation.viewholder.ArticleViewHolder
import timber.log.Timber

class ArticleAdapter(private val onItemClickListener:(Article)->Unit,private val onItemSavedListener:(Article)->Unit):RecyclerView.Adapter<ArticleViewHolder>() {

    private var articleList = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.news_item,parent,false)
        return ArticleViewHolder(containerView,{
            val article = articleList.get(it)
            onItemClickListener.invoke(article)
        },{

            val article = articleList.get(it)
            Timber.e("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ${article.author}")
            onItemSavedListener.invoke(article)

        })
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList.get(position))
    }

    fun setArticleList(newList:List<Article>){
        val diffCallBack = ArticleDiffCallBack(articleList,newList)
        val diffResults = DiffUtil.calculateDiff(diffCallBack)
        articleList.clear()
        articleList.addAll(newList)
        diffResults.dispatchUpdatesTo(this)
    }
}