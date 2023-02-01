package com.softsquared.template.kotlin.src.main.mainHome

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityDetailItemBinding

class DetailItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailItemBinding.inflate(layoutInflater)

        setContentView(binding.root)

    }
}