package com.softsquared.template.kotlin.src.main.mainHome

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.MainActivity
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityDetailBinding
import com.softsquared.template.kotlin.src.main.Chatting.ChatActivity


class DetailActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val snapHelper = PagerSnapHelper()
//        snapHelper.attachToRecyclerView(binding.recyclerview)

        val intent = intent
        val postid = intent.getStringExtra("postid")
        val location = intent.getStringExtra("location")
        val time = intent.getStringExtra("time")
        val datacontent = intent.getStringExtra("datacontent")

        binding.name.setText(postid)
        binding.featureName.setText(postid)
        binding.featureLocation.setText(location)
        binding.featureTime.setText(time)
        binding.content.setText(datacontent)

        binding.backBtnImg.setOnClickListener{
            finish()
        }

        binding.messageBtnImg.setOnClickListener{
                val intent = Intent(this,ChatActivity::class.java)
                intent.putExtra("postid",postid)
                intent.putExtra("datacontent",datacontent)
                startActivity(intent);
        }

//        val backMenu = findViewById<ImageView>(R.id.back_btn_img)
//        fun moveToHome(){
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//        backMenu.setOnClickListener{
//            moveToHome()
//        }

//        val cardMenu = findViewById<ImageView>(R.id.card_menu)
//
//        val list = ArrayList<MainData>()
//        list.add(MainData("숩", "위치 비밀",10,"밥 먹으실 분 있나요?"))
//        list.add(MainData("밤비", "위치 비밀",11,"밥 먹으실 분 있나요?"))
//        list.add(MainData("우니", "위치 비밀",12,"밥 먹으실 분 있나요?"))
//        list.add(MainData("라나", "위치 비밀",10,"밥 먹으실 분 있나요?"))
//        list.add(MainData("오리", "위치 비밀",9,"밥 먹으실 분 있나요?"))


//        val adapter = DetailAdapter(list)
//        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
//        binding.recyclerview.layoutManager = layoutManager
//        binding.recyclerview.adapter = adapter
   }
}