package com.softsquared.template.kotlin.src.main.signup

import android.graphics.Color
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.databinding.SignUpRecyclerViewItemUnivBinding

class UnivDataRVAdapter(private val dataList:ArrayList<UnivData>):RecyclerView.Adapter<UnivDataRVAdapter.DataViewHolder>() {

    inner class DataViewHolder(private val viewBinding:SignUpRecyclerViewItemUnivBinding):RecyclerView.ViewHolder(viewBinding.root){
        fun bind(data: UnivData){
            viewBinding.SignUpRecyclerViewItemUnivTextView.text=data.univName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding=SignUpRecyclerViewItemUnivBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    //item total 개수
   override fun getItemCount(): Int =dataList.size
}