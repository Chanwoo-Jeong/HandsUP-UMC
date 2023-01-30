package com.softsquared.template.kotlin.src.main.signup

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.softsquared.template.kotlin.databinding.FragmentSignUp1Binding

class SignUpFragment1 : Fragment(){
    private lateinit var binding:FragmentSignUp1Binding
    private lateinit var sendEventListener:SendEnableButtonSign
    private var checkAgreeServiceButton:Boolean=false
    private var checkAgreePrivacyButton:Boolean=false
    private var checkAgreeGPSButton:Boolean=false
    private var checkAgreeNoticeButton:Boolean=false
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
        binding= FragmentSignUp1Binding.inflate(layoutInflater)
        checkAllImageButtonIsTrue()

        //user check imageButtons
        binding.SignUpImageButtonAgreeService.setOnClickListener {
            if(checkAgreeServiceButton){
                checkAgreeServiceButton=false
                binding.SignUpImageButtonAgreeService.setColorFilter(Color.parseColor("#EFEFEF"))
            }else{
                checkAgreeServiceButton=true
                binding.SignUpImageButtonAgreeService.setColorFilter(Color.parseColor("#F47C16"))
            }
            checkAllImageButtonIsTrue()
        }

        binding.SignUpImageButtonAgreePrivacy.setOnClickListener {
            if(checkAgreePrivacyButton){
                checkAgreePrivacyButton=false
                binding.SignUpImageButtonAgreePrivacy.setColorFilter(Color.parseColor("#EFEFEF"))
            }else{
                checkAgreePrivacyButton=true
                binding.SignUpImageButtonAgreePrivacy.setColorFilter(Color.parseColor("#F47C16"))
            }
            checkAllImageButtonIsTrue()
        }

        binding.SignUpImageButtonAgreeGPS.setOnClickListener {
            if(checkAgreeGPSButton){
                checkAgreeGPSButton=false
                binding.SignUpImageButtonAgreeGPS.setColorFilter(Color.parseColor("#EFEFEF"))
            }else{
                checkAgreeGPSButton=true
                binding.SignUpImageButtonAgreeGPS.setColorFilter(Color.parseColor("#F47C16"))
            }
            checkAllImageButtonIsTrue()
        }

        binding.SignUpImageButtonAgreeNotice.setOnClickListener {
            if(checkAgreeNoticeButton){
                checkAgreeNoticeButton=false
                binding.SignUpImageButtonAgreeNotice.setColorFilter(Color.parseColor("#EFEFEF"))
            }else{
                checkAgreeNoticeButton=true
                binding.SignUpImageButtonAgreeNotice.setColorFilter(Color.parseColor("#F47C16"))
            }
            checkAllImageButtonIsTrue()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        checkAgreePrivacyButton=false
        checkAgreeServiceButton=false
        checkAgreeGPSButton=false
        checkAgreeNoticeButton=false
        checkAllImageButtonIsTrue()
    }

    fun checkAllImageButtonIsTrue(){
        if (checkAgreePrivacyButton&&checkAgreeServiceButton&&checkAgreeGPSButton&&checkAgreeNoticeButton){
            sendEventListener.sendSign(true)
        }else{
            sendEventListener.sendSign(false)
        }
    }
}