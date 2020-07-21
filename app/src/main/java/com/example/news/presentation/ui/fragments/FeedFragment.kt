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
import com.example.news.presentation.adapter.TabAdapter
import com.example.news.presentation.contract.ArticleContract
import com.example.news.presentation.ui.activities.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_feed.*
import timber.log.Timber

class FeedFragment : Fragment(R.layout.fragment_feed) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabPager.adapter = TabAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(tabPager)

    }



}