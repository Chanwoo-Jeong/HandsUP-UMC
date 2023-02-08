package com.softsquared.template.kotlin.src.main.signup

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivitySignUpMainBinding

import com.softsquared.template.kotlin.src.main.login.LoginMainActivity

class SignUpMainActivity : AppCompatActivity(),SendEnableButtonSign {
    private lateinit var binding: ActivitySignUpMainBinding
    private var power:Int=20
    private var fragment1=SignUpFragment1()
    private var fragment2=SignUpFragment2()
    private var fragment3=SignUpFragment3()
    private var fragment4=SignUpFragment4()
    private var fragment5=SignUpFragment5()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding= ActivitySignUpMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //signup first page is fragment1
        supportFragmentManager.beginTransaction()
            .add(binding.SignUpFrameLayout.id,fragment1)
            .commit()

        //when click next btn then replace next page and plus progress bar
        binding.SignUpButtonNext.setOnClickListener {
            plusProgressBar()
            replaceFragment()
        }

        //when click back btn then replace back page and minus progress bar
        binding.SignUpImageViewTopBarBackIcon.setOnClickListener {
            minusProgressBar()
            replaceFragment()
        }

    }

    fun plusProgressBar(){
        if (power!=100){
            power=power+20
            binding.SignUpProgressBar.setProgress(power)
        }else{
            val intent = Intent(this,LoginMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun minusProgressBar(){
        if(power==20){
            finish()
        }else{
            power=power-20
            binding.SignUpProgressBar.setProgress(power)
        }
    }
    fun replaceFragment(){
        when (power){
            20-> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(binding.SignUpFrameLayout.id, fragment1)
                    .commit()

                binding.SignUpButtonNext.text="다음"
            }
            40-> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(binding.SignUpFrameLayout.id, fragment2)
                    .commit()

                binding.SignUpButtonNext.text="다음"
            }
            60-> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(binding.SignUpFrameLayout.id, fragment3)
                    .commit()

                binding.SignUpButtonNext.text="다음"
            }
            80-> {
                supportFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(binding.SignUpFrameLayout.id, fragment4)
                    .commit()

                binding.SignUpButtonNext.text="다음"
            }
            100->{
                supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_left,R.anim.enter_from_left, R.anim.exit_to_right)
                .replace(binding.SignUpFrameLayout.id,fragment5)
                .commit()

                binding.SignUpButtonNext.text="핸즈업 들어가기"
            }
        }

    }

    override fun sendSign(isEnable: Boolean) {
        if (isEnable){
            val enableButtonBackground= ResourcesCompat.getDrawable(resources, R.drawable.enable_button_background, null)
            val disableButtonBackground= ResourcesCompat.getDrawable(resources, R.drawable.disable_button_background, null)
            binding.SignUpButtonNext.background=enableButtonBackground
            binding.SignUpButtonNext.isEnabled=true
            //binding.SignUpButtonNext.setBackgroundColor(Color.parseColor("#F47C16"))
        }else{
            val enableButtonBackground= ResourcesCompat.getDrawable(resources, R.drawable.enable_button_background, null)
            val disableButtonBackground= ResourcesCompat.getDrawable(resources, R.drawable.disable_button_background, null)
            binding.SignUpButtonNext.background=disableButtonBackground
            binding.SignUpButtonNext.isEnabled=false
            //binding.SignUpButtonNext.setBackgroundColor(Color.parseColor("#DBDBDB"))
        }
    }
}