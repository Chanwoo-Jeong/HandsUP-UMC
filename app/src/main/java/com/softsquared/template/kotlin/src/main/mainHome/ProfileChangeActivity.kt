package com.softsquared.template.kotlin.src.main.mainHome

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityProfileChangeBinding

class ProfileChangeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileChangeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProfileChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var backProfileBtn=findViewById<ImageView>(R.id.profile_back_btn)
        fun moveToProfile(){
            val intent= Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }
        backProfileBtn.setOnClickListener {
            moveToProfile()
        }
    }
}