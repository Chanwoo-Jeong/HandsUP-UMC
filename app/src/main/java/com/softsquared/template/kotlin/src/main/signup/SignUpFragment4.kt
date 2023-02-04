package com.softsquared.template.kotlin.src.main.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.softsquared.template.kotlin.databinding.FragmentSignUp4Binding

class SignUpFragment4: Fragment()  {
    private lateinit var binding:FragmentSignUp4Binding
    private lateinit var sendEventListener:SendEnableButtonSign

    private var userNickName=""
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
        binding=FragmentSignUp4Binding.inflate(layoutInflater)

        //hide nickname error textview
        binding.SignUpTextViewEnterNickNameError.isVisible=false

        //check that nickname duplicate
        binding.SignUpEditTextNickName.doOnTextChanged { text, start, before, count ->
            userNickName=text.toString()

            if(userNickName!=""){
                sendEventListener.sendSign(true)
            }else{
                sendEventListener.sendSign(false)
            }

        }

        return binding.root
    }
    override fun onResume() {
        super.onResume()
        sendEventListener.sendSign(false)
    }

}