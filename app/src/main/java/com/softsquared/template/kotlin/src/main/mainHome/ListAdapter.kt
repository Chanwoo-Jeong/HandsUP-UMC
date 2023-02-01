package com.softsquared.template.kotlin.src.main.mainHome

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template.kotlin.ChatActivity
import com.softsquared.template.kotlin.R

class ListAdapter(private val list: ArrayList<MainData>,private val context: Context) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(data: MainData) {

            var postid = data.name
            var listBox = itemView.findViewById<ConstraintLayout>(R.id.list_box)
            var featureName = itemView.findViewById<TextView>(R.id.feature_name)
            var location = itemView.findViewById<TextView>(R.id.feature_location)
            var time = itemView.findViewById<TextView>(R.id.feature_time)
            var content = itemView.findViewById<TextView>(R.id.content)

            featureName.text = data.name
            location.text = data.location
            time.text = data.time.toString() + "분전"
            content.text = data.content

            listBox.setOnClickListener {
                val intent = Intent(context, ChatActivity::class.java)
                intent.putExtra("postid",postid.toString())
                context.startActivity(intent);
            }

        }
    }
}