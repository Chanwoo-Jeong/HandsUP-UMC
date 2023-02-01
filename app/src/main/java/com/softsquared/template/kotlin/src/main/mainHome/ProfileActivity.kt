package com.softsquared.template.kotlin.src.main.mainHome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityProfileBinding
import com.softsquared.template.kotlin.src.main.MainActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backBtn = findViewById<ImageView>(R.id.profile_homeBack_btn)
        fun moveToHome(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        backBtn.setOnClickListener {
            moveToHome()
        }

        val profileChangeBtn = findViewById<TextView>(R.id.profile_change_btn)
        fun moveToProfileChange(){
            val intent=Intent(this,ProfileChangeActivity::class.java)
            startActivity(intent)
        }
        profileChangeBtn.setOnClickListener {
            moveToProfileChange()
        }
    }
}