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
import com.example.news.presentation.adapter.SavedArticleAdapter
import com.example.news.presentation.contract.ArticleContract
import com.example.news.presentation.ui.activities.MainActivity
import com.example.news.presentation.ui.activities.WebActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_database.*

class DataBaseFragment : Fragment(R.layout.fragment_database) {

    lateinit var viewModel:ArticleContract.ViewModel
    lateinit var savedArticleAdapter:SavedArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).articleViewModel

        savedArticleAdapter = SavedArticleAdapter({
            val intent = Intent(activity, WebActivity::class.java)
            intent.putExtra(Constants.NEWS_URL,it.url)
            startActivity(intent)
        },{
            val article = it
            viewModel.deleteArticle(article)
            Snackbar.make(view,"Article deleted",Snackbar.LENGTH_SHORT).apply {
                setAction("Undo"){
                    viewModel.saveArticle(article)
                }
                show()
            }
        })

        savedRcyclerId.apply {
            adapter = savedArticleAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer {
            savedArticleAdapter.setArticleList(it)
        })


    }


}