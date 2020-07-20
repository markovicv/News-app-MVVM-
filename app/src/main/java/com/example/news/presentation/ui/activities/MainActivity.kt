package com.example.news.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.news.R
import com.example.news.presentation.ui.fragments.DataBaseFragment
import com.example.news.presentation.ui.fragments.FeedFragment
import com.example.news.presentation.ui.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val feedFragment = FeedFragment()
        val dataBaseFragment = DataBaseFragment()
        val settingsFragment = SettingsFragment()

        supportFragmentManager.beginTransaction().replace(R.id.containerFL,feedFragment).commit()

        bottomNavView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.feedId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerFL,feedFragment).commit()

                }

                R.id.dbId ->{
                    supportFragmentManager.beginTransaction().replace(R.id.containerFL,dataBaseFragment).commit()

                }
                R.id.settingsId -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerFL,settingsFragment).commit()
                }
            }
            true
        }


    }



}
