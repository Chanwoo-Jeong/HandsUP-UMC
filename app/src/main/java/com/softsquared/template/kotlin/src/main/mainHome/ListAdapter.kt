package com.softsquared.template.kotlin.src.main.mainHome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.R

class ListAdapter(private val list: ArrayList<MainData>):RecyclerView.Adapter<ListAdapter.ViewHolder> (){
    //아이템의 갯수
    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun bindItems(data : MainData){
            itemView.findViewById<TextView>(R.id.feature_name).text=data.name
            itemView.findViewById<TextView>(R.id.feature_location).text=data.location
            itemView.findViewById<TextView>(R.id.feature_time).text=data.time.toString()+"분전"
            itemView.findViewById<TextView>(R.id.content).text=data.content
            //각각의 아이템 클릭시
            itemView.setOnClickListener(
                {
                    Toast.makeText(itemView.context, "아이템 '${data.name}'를 클릭했습니다.", Toast.LENGTH_LONG).show()
                }
            )
        }
    }
}