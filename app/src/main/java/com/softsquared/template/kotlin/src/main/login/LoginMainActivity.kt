package com.softsquared.template.kotlin.src.main.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.doOnTextChanged
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivityLoginMainBinding
import com.softsquared.template.kotlin.src.main.MainActivity
import com.softsquared.template.kotlin.src.main.myAccount.SearchPasswordActivity
import com.softsquared.template.kotlin.src.main.signup.SignUpMainActivity

class LoginMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginMainBinding
    private var emailText:String=""
    private var passwordText:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set login btn background color
        binding.LoginPageEditTextEmail.doOnTextChanged { text, start, before, count ->
            resetEditTextBackground()
            emailText=text.toString()
            if(checkEmailAndPasswordIsNull()){
                binding.LoginPageButtonLogin.isEnabled=false
                binding.LoginPageButtonLogin.setBackgroundColor(Color.parseColor("#DBDBDB"))
            }else{
                binding.LoginPageButtonLogin.isEnabled=true
                binding.LoginPageButtonLogin.setBackgroundColor(Color.parseColor("#F47C16"))
            }
        }

        binding.LoginPageTextInputEditTextPassword.doOnTextChanged { text, start, before, count ->
            resetEditTextBackground()
            passwordText=text.toString()
            if(checkEmailAndPasswordIsNull()){
                binding.LoginPageButtonLogin.isEnabled=false
                binding.LoginPageButtonLogin.setBackgroundColor(Color.parseColor("#DBDBDB"))
            }else{
                binding.LoginPageButtonLogin.isEnabled=true
                binding.LoginPageButtonLogin.setBackgroundColor(Color.parseColor("#F47C16"))
            }
        }

        //move find password activity when click find password TextView
        binding.LoginPageTextViewChangePassword.setOnClickListener {
            val intent = Intent(this,SearchPasswordActivity::class.java)
            startActivity(intent)
        }

        //move sign up activity when click sign up TextView
        binding.LoginPageTextViewSignUp.setOnClickListener {
            val intent = Intent(this,SignUpMainActivity::class.java)
            startActivity(intent)
        }

        //move home activity or logIn error when click logIn Button
        binding.LoginPageButtonLogin.setOnClickListener {
            //move home activity
            if(checkEmailAndPasswordIsTrue()){
                Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                //logIn error
                val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_error_background, null)
                binding.LoginPageEditTextEmail.background=transition

                val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_error_outline_24, null)
                binding.LoginPageEditTextEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null)

            }
        }
    }
    fun checkEmailAndPasswordIsNull() :Boolean{
        return ((emailText == "")||(passwordText==""))
    }

    fun checkEmailAndPasswordIsTrue():Boolean{
        return ((emailText=="bambi")&&(passwordText=="1111"))
    }
    fun resetEditTextBackground(){
        val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_background, null)
        binding.LoginPageEditTextEmail.background=transition

        binding.LoginPageEditTextEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
    }
}