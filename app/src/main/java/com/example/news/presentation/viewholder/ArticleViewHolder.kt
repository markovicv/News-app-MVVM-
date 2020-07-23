package com.example.news.presentation.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.data.model.api_response.Article
import com.example.news.data.model.domain.ArticleDomain
import kotlinx.android.synthetic.main.news_item.view.*

class ArticleViewHolder(itemview:View,private val onItemClickListener:(Int)->Unit,private val onItemSaveListener:(Int)->Unit):RecyclerView.ViewHolder(itemview) {

    init {
        itemview.setOnClickListener {
            onItemClickListener.invoke(adapterPosition)
        }
        itemview.saveBtnId.setOnClickListener {
            onItemSaveListener.invoke(adapterPosition)
        }
    }


    fun bind(article: Article){
        itemView.authorId.setText(article.author)
        itemView.titleId.setText(article.title)
        itemView.descriptionId.setText(article.description)
        itemView.sourceId.setText(article.source?.name)
        itemView.publishedId.setText(article.publishedAt)
        Glide.with(itemView).load(article.urlToImage).into(itemView.mainImgId)

    }
}