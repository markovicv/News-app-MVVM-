package com.example.news.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import com.example.news.presentation.ui.fragments.ScienceFragment
import com.example.news.presentation.ui.fragments.SportsFragment
import com.example.news.presentation.ui.fragments.TopHeadlinesFragment

class TabAdapter(fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position){

            0 ->{
                TopHeadlinesFragment()
            }
            1 ->{
                SportsFragment()
            }
            else->{
                ScienceFragment()
            }

        }    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"TOP"
            1->"SPORTS"
            else ->{
                return "SCIENCE"
            }
        }

    }
}