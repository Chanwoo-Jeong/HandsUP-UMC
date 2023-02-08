package com.softsquared.template.kotlin.src.main.mainAlert

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.softsquared.template.kotlin.*
import com.softsquared.template.kotlin.databinding.ActivityMainAlertBinding
import com.softsquared.template.kotlin.src.main.mainHome.MainData


class MainActivityAlert : AppCompatActivity() {
    private lateinit var viewbinding: ActivityMainAlertBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityMainAlertBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        val switchCompat = findViewById<SwitchCompat>(R.id.switchBtn)
        switchCompat.setVisibility(View.INVISIBLE);

        supportFragmentManager
            .beginTransaction()
            .replace(viewbinding.frameFragment.id, FirstFragment())
            .commitAllowingStateLoss()

        viewbinding.alertBtn.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewbinding.frameFragment.id, FirstFragment())
                .commitAllowingStateLoss()
            viewbinding.alertBtn.setTextColor(Color.parseColor("#000000"))
            viewbinding.msgBtn.setTextColor(Color.parseColor("#D3D3D3"))
        }

        viewbinding.msgBtn.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(viewbinding.frameFragment.id, SecondFragment())
                .commitAllowingStateLoss()
            viewbinding.alertBtn.setTextColor(Color.parseColor("#D3D3D3"))
            viewbinding.msgBtn.setTextColor(Color.parseColor("#000000"))
        }

        val plusBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        val homeBtn = findViewById<ImageView>(R.id.toolbar_home_btn)
        val alertBtn = findViewById<ImageView>(R.id.toolbar_alert_btn)


        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val name = result.data?.getStringExtra("name")
                val location = result.data?.getStringExtra("location")
                val postContent = result.data?.getStringExtra("postContent")

                val database = Firebase.database
                val myRef = database.getReference("postRoom")

                var postRoom = MainData(name.toString(),location.toString(),10,postContent.toString())
                myRef.push().setValue(postRoom)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        plusBtn.setOnClickListener{
            Log.d("MainActivity","im upload button")
            val intent = Intent(this, HuploadActivity::class.java)
            getResultText.launch(intent)
        }

        alertBtn.setOnClickListener{
            val intent=Intent(this, MainActivityAlert::class.java)
            startActivity(intent)
        }

        fun moveToHome(){
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        homeBtn.setOnClickListener{
            moveToHome()
        }

    }
}