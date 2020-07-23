package com.example.news.presentation.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.Constants
import com.example.news.R
import com.example.news.Resource
import com.example.news.presentation.adapter.ArticleAdapter
import com.example.news.presentation.contract.ArticleContract
import com.example.news.presentation.ui.activities.MainActivity
import com.example.news.presentation.ui.activities.WebActivity
import kotlinx.android.synthetic.main.fragment_top_headlines.*

class TopHeadlinesFragment : Fragment(R.layout.fragment_top_headlines) {
    lateinit var viewModel: ArticleContract.ViewModel
    private lateinit var articleAdapter:ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRv()
        initRefreshFeed()







    }
    private fun initViewModel(){
        viewModel = (activity as MainActivity).articleViewModel

        viewModel.topHeadLinesNews.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    it.data?.let {
                        articleAdapter.setArticleList(it.articles)
                    }
                }
                is Resource.Error->{
                    it.message?.let {
                        Toast.makeText(activity,it, Toast.LENGTH_SHORT).show()
                    }
                }

            }
        })
        viewModel.getTopHeadLineNews(Constants.COUNTRY_NEWS)
    }
    private fun initRv(){
        articleAdapter = ArticleAdapter({
            val intent = Intent(activity,WebActivity::class.java)
            intent.putExtra(Constants.NEWS_URL,it.url)
            startActivity(intent)

        },{
            viewModel.saveArticle(it)
            Toast.makeText(activity,Constants.SAVED,Toast.LENGTH_SHORT).show()

        })
        recyclerId.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
    private fun initRefreshFeed(){

        refreshTopId.setOnRefreshListener {
            viewModel.getTopHeadLineNews(Constants.COUNTRY_NEWS)
            refreshTopId.isRefreshing = false
        }
    }
}