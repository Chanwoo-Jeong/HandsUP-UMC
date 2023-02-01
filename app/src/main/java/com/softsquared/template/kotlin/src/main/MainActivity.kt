package com.softsquared.template.kotlin.src.main

import com.kakao.sdk.common.util.Utility
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.Menu
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityMainHomeBinding
import com.softsquared.template.kotlin.src.main.mainHome.DetailActivity
import com.softsquared.template.kotlin.src.main.mainHome.ProfileActivity
import com.softsquared.template.kotlin.src.main.mainHome.listFragment
import com.softsquared.template.kotlin.src.main.mainHome.mapFragment
import net.daum.mf.map.api.MapView
import java.security.MessageDigest


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        var keyHash = Utility.getKeyHash(this)
        Log.d("keyHash",keyHash)


        val title = findViewById<TextView>(R.id.main_schoolName)
        val plusBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        val homeBtn = findViewById<ImageView>(R.id.toolbar_home_btn)

        fun moveToProfile(){
            val intent=Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }
        title.setOnClickListener {
            moveToProfile()
        }

        fun moveToPage(){
            val intent=Intent(this,DetailActivity::class.java)
            startActivity(intent)
        }
        plusBtn.setOnClickListener{
            moveToPage()
        }

        fun moveToHome(){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        homeBtn.setOnClickListener{
            moveToHome()
        }




        binding.mainHomeTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var text = tab!!.text.toString()
                Log.d("test1",tab!!.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        val transaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout,mapFragment()).commit()

        val switchBtn: SwitchCompat = findViewById(R.id.switchBtn)

        switchBtn.setOnCheckedChangeListener{ p0, isChecked ->
            if(isChecked){
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout,listFragment())
                transaction.commit()
            } else {
                val transaction=supportFragmentManager.beginTransaction()
               transaction.replace(R.id.frameLayout,mapFragment())
                transaction.commit()
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }


}