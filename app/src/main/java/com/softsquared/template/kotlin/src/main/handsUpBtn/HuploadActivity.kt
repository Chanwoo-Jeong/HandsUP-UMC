package com.softsquared.template.kotlin

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.internal.InternalTokenProvider
import com.softsquared.template.kotlin.databinding.HandsupbtnBinding



class HuploadActivity : AppCompatActivity()  {
    private lateinit var viewbinding: HandsupbtnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = HandsupbtnBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        viewbinding.cancelButton.setOnClickListener{
            finish()
        }


        viewbinding.seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                viewbinding.seekbarValue.setText(String.format("%d h", seekBar.getProgress()))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

                // [SeekBar 터치 시작]
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // [SeekBar 터치 종료]
            }
        })


        val btn1 = viewbinding.toggleButton
        val btn2 = viewbinding.toggleButton2
        val btn3 = viewbinding.toggleButton3
        val btn4 = viewbinding.toggleButton4
        val btn5 = viewbinding.toggleButton5

        var btnarr = arrayOf(btn1, btn2, btn3, btn4, btn5)


        for( btn in btnarr){
            btn.setOnClickListener{
                for(btn in btnarr) {
                    btn.setTextColor(Color.parseColor("#000000"))
                }
                if (btn.isChecked) {
                    btn.setTextColor(Color.parseColor("#d9534f"))
                } else {
                    btn.setTextColor(Color.parseColor("#000000"))
                }
            }
        }

        viewbinding.uploadBtn.setOnClickListener {

            var location = if(viewbinding.locationSwitch.isChecked){
                viewbinding.locationText.getText().toString()
            } else {
                "위치비밀"
            }

            var tag = btnarr.filter { btn -> btn.isChecked === true }
            var duration = viewbinding.seekBar.getProgress()
            Log.d("duration", duration.toString())

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name",viewbinding.nickname.getText().toString())
            intent.putExtra("location" , location)
            intent.putExtra("postContent",viewbinding.Content.getText().toString())
            intent.putExtra("tag",tag[0].toString())
            intent.putExtra("duration",duration)
            setResult(RESULT_OK,intent)
            finish()
            //액티비티를 끝내는 코드
        }

    }

//
//    private fun setTextColorChange(btn: ToggleButton) {
//        if (btn != null) {
//            if (btn.isChecked) {
//                btn.setTextColor(Color.parseColor("#215449"))
//                return btn.getText().toString()
//            } else {
//                btn.setTextColor(Color.parseColor("#000000"))
//                return ""
//            }
//
//        }
//        return ""
//    }


}
