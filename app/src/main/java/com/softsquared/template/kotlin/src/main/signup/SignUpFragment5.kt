package com.softsquared.template.kotlin.src.main.signup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.softsquared.template.kotlin.databinding.FragmentSignUp5Binding

class SignUpFragment5: Fragment() {
    private lateinit var binding:FragmentSignUp5Binding
    private lateinit var sendEventListener:SendEnableButtonSign

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
        binding= FragmentSignUp5Binding.inflate(layoutInflater)


        return binding.root
    }
    override fun onResume() {
        super.onResume()
        sendEventListener.sendSign(true)
    }
}