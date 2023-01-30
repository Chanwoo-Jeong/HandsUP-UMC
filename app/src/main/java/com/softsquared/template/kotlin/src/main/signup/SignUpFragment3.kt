package com.softsquared.template.kotlin.src.main.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.softsquared.template.kotlin.databinding.FragmentSignUp3Binding

class SignUpFragment3: Fragment() {
    private lateinit var binding: FragmentSignUp3Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSignUp3Binding.inflate(layoutInflater)
        return binding.root
    }
}