package com.softsquared.template.kotlin

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
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.softsquared.template.kotlin.src.main.handsUpBtn.MainActivityAlert
import com.softsquared.template.kotlin.src.main.mainHome.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainHomeBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    var id : String = "roby"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val title = findViewById<TextView>(R.id.main_schoolName)
        val plusBtn = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        val homeBtn = findViewById<ImageView>(R.id.toolbar_home_btn)
        val alertBtn = findViewById<ImageView>(R.id.toolbar_alert_btn)

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

        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val name = result.data?.getStringExtra("name")
                val postContent = result.data?.getStringExtra("postContent")

                val listFragment = listFragment()
                val bundle = Bundle()

                bundle.putString("name", name.toString())
                bundle.putString("postContent", postContent.toString())
                Log.d("bundle",bundle.toString())
                listFragment.arguments = bundle

                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout,listFragment)
                    .commitAllowingStateLoss()
            }
        }

        plusBtn.setOnClickListener{
            Log.d("MainActivity","im upload button")
            val intent = Intent(this, HuploadActivity::class.java)
            getResultText.launch(intent)
        }

        fun moveToHome(){
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        homeBtn.setOnClickListener{
            moveToHome()
        }

        alertBtn.setOnClickListener{
            val intent=Intent(this,MainActivityAlert::class.java)
            startActivity(intent)
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



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }


}