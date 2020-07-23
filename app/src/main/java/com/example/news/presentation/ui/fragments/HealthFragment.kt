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
import kotlinx.android.synthetic.main.fragment_health.*
import kotlinx.android.synthetic.main.fragment_science.*
import kotlinx.android.synthetic.main.fragment_top_headlines.*

class HealthFragment :Fragment(R.layout.fragment_health) {

    private lateinit var articleAdapter:ArticleAdapter
    lateinit var viewModel: ArticleContract.ViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        inintRv()
        initRefreshFeed()






    }
    private fun initViewModel(){
        viewModel = (activity as MainActivity).articleViewModel

        viewModel.healthNews .observe(viewLifecycleOwner, Observer {
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
        viewModel.getHealthNews(Constants.COUNTRY_NEWS,Constants.HEALTH)
    }
    private fun inintRv(){
        articleAdapter = ArticleAdapter({
            val intent = Intent(activity, WebActivity::class.java)
            intent.putExtra(Constants.NEWS_URL,it.url)
            startActivity(intent)
        },{
            viewModel.saveArticle(it)

        })
        recyclerHealth.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
    private fun initRefreshFeed(){
        refreshHealth.setOnRefreshListener {
            viewModel.getHealthNews(Constants.COUNTRY_NEWS,Constants.HEALTH)
            refreshHealth.isRefreshing = false
        }
    }


}