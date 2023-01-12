package com.softsquared.template.kotlin.src.main.mainHome

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val NUM_TABS = 5

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TabFragment1()
            1 -> return TabFragment2()
            2 -> return TabFragment3()
            3 -> return TabFragment4()
            4 -> return TabFragment5()
        }
        return TabFragment1()
    }
}