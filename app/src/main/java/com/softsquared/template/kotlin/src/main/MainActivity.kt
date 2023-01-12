package com.softsquared.template.kotlin.src.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityMainHomeBinding
import com.softsquared.template.kotlin.src.main.mainHome.ViewPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainHomeBinding

    private val tabTitleArray = arrayOf(
        "#전체 ",
        "#밥 ",
        "#여행 ",
        "#스터디 ",
        "#취미 ",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewPager = binding.viewPager
        var tabLayout = binding.tabLayout
        var toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        viewPager.adapter=ViewPagerAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout,viewPager) { tab,position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

}