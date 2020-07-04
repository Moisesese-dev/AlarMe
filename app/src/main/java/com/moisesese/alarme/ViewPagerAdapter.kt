package com.moisesese.alarme

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(private val myContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }
            else -> {
                FirstFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Classic"
            1 -> "Custom"
            else -> {
                return "Third Tab"
            }
        }
    }
    override fun getCount(): Int {
        return 2
    }
}