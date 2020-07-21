package com.example.news.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.news.R
import com.example.news.presentation.contract.ArticleContract
import com.example.news.presentation.ui.activities.MainActivity

class DataBaseFragment : Fragment(R.layout.fragment_database) {

    lateinit var viewModel:ArticleContract.ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).articleViewModel

    }


}