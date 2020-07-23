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
import kotlinx.android.synthetic.main.fragment_technology.*
import kotlinx.android.synthetic.main.fragment_top_headlines.*
import kotlinx.android.synthetic.main.fragmnet_sports.*

class SportsFragment :Fragment(R.layout.fragmnet_sports) {

    lateinit var viewModel:ArticleContract.ViewModel
    private lateinit var articleAdapter: ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRv()
        initRefreshFeed()





    }

    private fun initViewModel(){
        viewModel = (activity as MainActivity).articleViewModel

        viewModel.sportNews .observe(viewLifecycleOwner, Observer {
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
        viewModel.getSportsNews(Constants.COUNTRY_NEWS,Constants.SPORTS)
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
        recyclerSports.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
    private fun initRefreshFeed(){
        refreshSportId.setOnRefreshListener {
            viewModel.getSportsNews(Constants.COUNTRY_NEWS,Constants.SPORTS)
            refreshSportId.isRefreshing = false
        }
    }
}