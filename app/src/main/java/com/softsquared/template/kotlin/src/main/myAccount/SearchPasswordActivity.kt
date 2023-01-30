package com.softsquared.template.kotlin.src.main.myAccount

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.doOnTextChanged
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.ActivitySearchPasswordBinding

class SearchPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchPasswordBinding
    private var email:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySearchPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set btn color
        binding.SearchPasswordPageEditTextEnterEmail.doOnTextChanged { text, start, before, count ->
            resetEditTextBackground()
            email=text.toString()

            if(checkEmailIsNull()){
                binding.SearchPasswordPageButtonSendPassword.isEnabled=false
                binding.SearchPasswordPageButtonSendPassword.setBackgroundColor(Color.parseColor("#DBDBDB"))
            }else{
                binding.SearchPasswordPageButtonSendPassword.isEnabled=true
                binding.SearchPasswordPageButtonSendPassword.setBackgroundColor(Color.parseColor("#F47C16"))
            }
        }

        //click find Password btn
        binding.SearchPasswordPageButtonSendPassword.setOnClickListener {
            if(checkEmailIsTrue()){
                //exist email
                Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
                /*val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("key",binding.textFirst.text.toString())
                startActivity(intent)*/
            }else{
                //email error
                val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_error_background, null)
                binding.SearchPasswordPageEditTextEnterEmail.background=transition

                val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_error_outline_24, null)
                binding.SearchPasswordPageEditTextEnterEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null)

            }
        }

        //click back btn
        binding.SearchPasswordPageImageViewTopBarBackIcon.setOnClickListener {
            finish()
        }
    }


    fun checkEmailIsNull() :Boolean{
        return (email== "")
    }

    fun checkEmailIsTrue():Boolean{
        return (email=="bambi")
    }
    fun resetEditTextBackground(){
        val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_background, null)
        binding.SearchPasswordPageEditTextEnterEmail.background=transition
        binding.SearchPasswordPageEditTextEnterEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
    }
}