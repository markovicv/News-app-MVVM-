package com.example.news.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news.R
import com.example.news.presentation.contract.ArticleContract
import com.example.news.presentation.ui.fragments.DataBaseFragment
import com.example.news.presentation.ui.fragments.FeedFragment
import com.example.news.presentation.ui.fragments.SearchFragment
import com.example.news.presentation.viewmodel.ArticleViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
     val articleViewModel:ArticleContract.ViewModel by viewModel<ArticleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val feedFragment = FeedFragment()
        val dataBaseFragment = DataBaseFragment()
        val searchFragment = SearchFragment()

        supportFragmentManager.beginTransaction().replace(R.id.containerFL,feedFragment).commit()

        bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.feedId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerFL,feedFragment).commit()

                }

                R.id.dbId ->{
                    supportFragmentManager.beginTransaction().replace(R.id.containerFL,dataBaseFragment).commit()

                }
                R.id.searchId->{
                    supportFragmentManager.beginTransaction().replace(R.id.containerFL,searchFragment).commit()
                }



            }
            true
        }


    }



}
