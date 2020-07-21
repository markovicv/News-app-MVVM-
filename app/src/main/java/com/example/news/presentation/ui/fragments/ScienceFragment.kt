package com.example.news.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.R
import com.example.news.Resource
import com.example.news.presentation.adapter.ArticleAdapter
import com.example.news.presentation.contract.ArticleContract
import com.example.news.presentation.ui.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_top_headlines.*

class ScienceFragment : Fragment(R.layout.fragment_science) {

    lateinit var viewModel: ArticleContract.ViewModel
    private lateinit var articleAdapter: ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).articleViewModel

        articleAdapter = ArticleAdapter()
        recyclerId.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        viewModel.scienceNews .observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    it.data?.let {
                        articleAdapter.setArticleList(it.articles)
                    }
                }
                is Resource.Error->{
                    it.message?.let {
                        Toast.makeText(activity,"Error se dogodio", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        })
        viewModel.getScienceNews("us","science")
    }

}