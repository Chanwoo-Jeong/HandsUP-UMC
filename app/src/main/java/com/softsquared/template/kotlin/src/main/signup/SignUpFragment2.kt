package com.softsquared.template.kotlin.src.main.signup

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.softsquared.template.kotlin.databinding.FragmentSignUp2Binding

class SignUpFragment2: Fragment() {
    private lateinit var binding:FragmentSignUp2Binding
    private lateinit var selectedUniv:String
    private var univList= arrayOf(String())
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
        binding= FragmentSignUp2Binding.inflate(layoutInflater)

        //recycler view
        val dataList:ArrayList<UnivData> = arrayListOf()
        dataList.apply{
            add(UnivData("가천대"))
            add(UnivData("건국대"))
            add(UnivData("동국대"))
            add(UnivData("세종대"))
            add(UnivData("숭실대"))
        }
        val adapter=UnivDataRVAdapter(dataList)
        binding.SignUpRecyclerViewUniv.adapter=adapter
        binding.SignUpRecyclerViewUniv.layoutManager=LinearLayoutManager(activity)

        //number picker
        univList= arrayOf("가천대","건국대","동국대","세종대","숭실대")

        binding.SignUpNumberPickerUniv.maxValue=univList.size-1
        binding.SignUpNumberPickerUniv.minValue=0
        binding.SignUpNumberPickerUniv.value=0
        binding.SignUpNumberPickerUniv.wrapSelectorWheel=false
        binding.SignUpNumberPickerUniv.displayedValues=univList
        binding.SignUpNumberPickerUniv.setOnValueChangedListener { picker, oldVal, newVal ->
            Toast.makeText(activity,newVal.toString(),Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        sendEventListener.sendSign(true)
    }

    override fun onPause() {
        super.onPause()
        selectedUniv=univList.get(binding.SignUpNumberPickerUniv.value)
        Log.e("univ_pause",selectedUniv)
    }

}