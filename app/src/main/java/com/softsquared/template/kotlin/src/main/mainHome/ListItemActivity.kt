package com.softsquared.template.kotlin.src.main.mainHome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.softsquared.template.kotlin.databinding.ActivityDetailBinding
import com.softsquared.template.kotlin.databinding.ActivityListItemBinding

class ListItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}