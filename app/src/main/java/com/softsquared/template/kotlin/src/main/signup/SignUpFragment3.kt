package com.softsquared.template.kotlin.src.main.signup

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.softsquared.template.kotlin.R
import com.softsquared.template.kotlin.databinding.FragmentSignUp3Binding

class SignUpFragment3: Fragment() {
    private lateinit var binding: FragmentSignUp3Binding
    private lateinit var sendEventListener:SendEnableButtonSign

    private var userEmail=""
    private var userCode="-1"
    private var userPassword=""
    private var userPasswordCheck=""

    private var userCodeIsTrue=false
    private var userPasswordIsTrue=false
    private var userPasswordCheckIsTrue=false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //초기하
        sendEventListener=context as SendEnableButtonSign
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSignUp3Binding.inflate(layoutInflater)
        //set btn background from edit text (email)
        binding.SignUpEditTextEmail.doOnTextChanged { text, start, before, count ->
            userEmail=text.toString()
            if(userEmail!=""){
                binding.SignUpButtonGetCode.isEnabled=true
                binding.SignUpButtonGetCode.setBackgroundColor(Color.parseColor("#F47C16"))
            }else{
                binding.SignUpButtonGetCode.isEnabled=false
                binding.SignUpButtonGetCode.setBackgroundColor(Color.parseColor("#DBDBDB"))
            }
        }

        binding.SignUpButtonGetCode.setOnClickListener {
            Toast.makeText(activity,"click",Toast.LENGTH_SHORT).show()
        }

        //set edit text (code) background
        binding.SignUpEditTextCode.doOnTextChanged { text, start, before, count ->
            userCode=text.toString()
            print(userCode)
            if(userCode.toString()=="12345"){
                //correct
                userCodeIsTrue=true
                val transition= ResourcesCompat.getDrawable(resources, R.drawable.signup_edit_text_correct_background, null)
                binding.SignUpEditTextCode.background=transition

                val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_correct_24, null)
                binding.SignUpEditTextCode.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null)
            }else{
                userCodeIsTrue=false
                if(userCode.toString().length==5){
                    //error
                    val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_error_background, null)
                    binding.SignUpEditTextCode.background=transition

                    val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_error_outline_24, null)
                    binding.SignUpEditTextCode.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null)
                }else{
                    //default
                    val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_background, null)
                    binding.SignUpEditTextCode.background=transition

                    binding.SignUpEditTextCode.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
                }
            }
            checkAllEditTextIsTrue()
        }

        //set edit text (password) background
        binding.SignUpEditTextPassword.doOnTextChanged { text, start, before, count ->
            userPassword=text.toString()
            if(userPassword.length>=8){
                //correct
                userPasswordIsTrue=true
                val transition= ResourcesCompat.getDrawable(resources, R.drawable.signup_edit_text_correct_background, null)
                binding.SignUpEditTextPassword.background=transition

                val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_correct_24, null)
                binding.SignUpEditTextPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null)
            }else{
                userPasswordIsTrue=false
                //default
                val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_background, null)
                binding.SignUpEditTextPassword.background=transition

                binding.SignUpEditTextPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
            }
            checkAllEditTextIsTrue()
        }

        //set edit text (check password) background
        binding.SignUpTextInputEditTextCheckPassword.doOnTextChanged { text, start, before, count ->
            userPasswordCheck=text.toString()
            if(userPasswordCheck.length>=8){
                //correct
                userPasswordCheckIsTrue=true
                val transition= ResourcesCompat.getDrawable(resources, R.drawable.signup_edit_text_correct_background, null)
                binding.SignUpTextInputEditTextCheckPassword.background=transition

                val drawable: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.ic_baseline_correct_24, null)
                binding.SignUpTextInputEditTextCheckPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,drawable,null)
            }else{
                userPasswordCheckIsTrue=false
                //default
                val transition= ResourcesCompat.getDrawable(resources, R.drawable.login_edit_text_background, null)
                binding.SignUpTextInputEditTextCheckPassword.background=transition

                binding.SignUpTextInputEditTextCheckPassword.setCompoundDrawablesWithIntrinsicBounds(null,null,null,null)
            }
            checkAllEditTextIsTrue()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        sendEventListener.sendSign(false)
        userCodeIsTrue=false
        userPasswordIsTrue=false
        userPasswordCheckIsTrue=false

    }
    fun checkAllEditTextIsTrue(){
        if (userCodeIsTrue&&userPasswordIsTrue&&userPasswordCheckIsTrue){
            sendEventListener.sendSign(true)
        }else{
            sendEventListener.sendSign(false)
        }
    }
}