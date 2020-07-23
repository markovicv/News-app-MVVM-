package com.example.news.presentation.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.data.model.api_response.Article
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.android.synthetic.main.news_item.view.authorId
import kotlinx.android.synthetic.main.news_item.view.descriptionId
import kotlinx.android.synthetic.main.news_item.view.mainImgId
import kotlinx.android.synthetic.main.news_item.view.publishedId
import kotlinx.android.synthetic.main.news_item.view.sourceId
import kotlinx.android.synthetic.main.news_item.view.titleId
import kotlinx.android.synthetic.main.saved_news_item.view.*

class SavedArticleViewHolder(itemView:View,private val onItemClickListener:(Int)->Unit,private val onItemDeleteListener:(Int)->Unit) :RecyclerView.ViewHolder(itemView){

    init {
        itemView.setOnClickListener {
            onItemClickListener.invoke(adapterPosition)
        }
        itemView.deleteBtnId.setOnClickListener {
            onItemDeleteListener.invoke(adapterPosition)
        }
    }

    fun bind(article:Article){
        itemView.authorId.setText(article.author)
        itemView.titleId.setText(article.title)
        itemView.descriptionId.setText(article.description)
        itemView.sourceId.setText(article.source?.name)
        itemView.publishedId.setText(article.publishedAt)
        Glide.with(itemView).load(article.urlToImage).into(itemView.mainImgId)
    }
}