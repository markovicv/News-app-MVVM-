package com.example.news.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.data.model.api_response.Article
import com.example.news.presentation.diff.ArticleDiffCallBack
import com.example.news.presentation.viewholder.ArticleViewHolder
import com.example.news.presentation.viewholder.SavedArticleViewHolder

class SavedArticleAdapter(private val onItemClickListener:(Article)->Unit,private val onItemDeleteListener:(Article)->Unit) :RecyclerView.Adapter<SavedArticleViewHolder>(){

    private var articleList = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.saved_news_item,parent,false)
        return SavedArticleViewHolder(containerView,{
            val article = articleList.get(it)
            onItemClickListener.invoke(article)
        },{
            val article = articleList.get(it)
            onItemDeleteListener.invoke(article)
        })
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: SavedArticleViewHolder, position: Int) {
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