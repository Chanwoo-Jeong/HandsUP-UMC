package com.softsquared.template.kotlin.src.main.signup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivitySignUpMainBinding

class SignUpMainActivity : AppCompatActivity(),SendEnableButtonSign {
    private lateinit var binding: ActivitySignUpMainBinding
    private var power:Int=20
    private var fragment1=SignUpFragment1()
    private var fragment2=SignUpFragment2()
    private var fragment3=SignUpFragment3()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding= ActivitySignUpMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(binding.SignUpFrameLayout.id,fragment1)
            .commit()


        binding.SignUpButtonNext.setOnClickListener {
            plusProgressBar()
            replaceFragment()
        }

        binding.SignUpImageViewTopBarBackIcon.setOnClickListener {
            minusProgressBar()
            replaceFragment()
        }

    }

    fun plusProgressBar(){
        if (power!=100){
            power=power+16
            binding.SignUpProgressBar.setProgress(power)
        }
    }
    fun minusProgressBar(){
        if(power==20){
            finish()
        }else{
            power=power-16
            binding.SignUpProgressBar.setProgress(power)
        }
    }
    fun replaceFragment(){
        when (power){
            20->supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(binding.SignUpFrameLayout.id,fragment1)
                .commit()
            36->supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(binding.SignUpFrameLayout.id,fragment2)
                .commit()
            52->supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(binding.SignUpFrameLayout.id,fragment3)
                .commit()
            68->supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(binding.SignUpFrameLayout.id,fragment2)
                .commit()
            84->supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(binding.SignUpFrameLayout.id,fragment3)
                .commit()
            100->supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left)
                .replace(binding.SignUpFrameLayout.id,fragment2)
                .commit()
        }

    }

    override fun sendSign(isEnable: Boolean) {
        if (isEnable){
            binding.SignUpButtonNext.isEnabled=true
            binding.SignUpButtonNext.setBackgroundColor(Color.parseColor("#F47C16"))
        }else{
            binding.SignUpButtonNext.isEnabled=false
            binding.SignUpButtonNext.setBackgroundColor(Color.parseColor("#DBDBDB"))
        }
    }
}