package com.softsquared.template.kotlin.src.main.Chatting

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.softsquared.template.kotlin.src.main.Note.NoteData
import com.softsquared.template.kotlin.src.main.Note.Notedapter
import com.softsquared.template.kotlin.R

import com.softsquared.template.kotlin.databinding.ActivityMainUchatBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun WhatTime(): String? {
    val dateTime = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("hh:mm"))
    return dateTime
}

class ChatActivity : AppCompatActivity() {
    private lateinit var viewbinding: ActivityMainUchatBinding

    var myid = "userthree"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val postid = intent.getStringExtra("postid")
        val datacontent = intent.getStringExtra("datacontent")
        val roomname = intent.getStringExtra("roomname")
        val from = intent.getStringExtra("from")

        viewbinding = ActivityMainUchatBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        viewbinding.name.setText(postid)
        viewbinding.messageContent.setText(datacontent)


        if (roomname != null) {
            if(roomname.isNotEmpty()){
                Log.d("from",roomname)
                val database = Firebase.database
                val myRef = database.getReference("message").child(roomname)
                val NmyRef = database.getReference("Note")

                val items: ArrayList<ChatData> = arrayListOf()

                //리사이클러뷰 어댑터 연결
                val rv = findViewById<RecyclerView>(R.id.recycler_view)
                val rvAdapter = ChatAdapter(items , this, myid)

                rv.adapter = rvAdapter
                rv.layoutManager = LinearLayoutManager(this)

                myRef.addChildEventListener(object : ChildEventListener {
                    override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                        var Chatd =  dataSnapshot.getValue(ChatData::class.java)
                        var name = Chatd?.mynickName
                        var msg = Chatd?.msg
                        var stime = Chatd?.time
                        items.apply {
                            add(ChatData(name.toString(),msg.toString(),stime.toString()))
                        }
                        rvAdapter.notifyDataSetChanged()

                    }
                    override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}
                    override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
                    override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
                    override fun onCancelled(databaseError: DatabaseError) {}
                })

                viewbinding.umsgbtn.setOnClickListener {
                    val time:String = WhatTime().toString()
                    val msg:String = viewbinding.utextmsg.text.toString()
                    if(msg.isNotEmpty()) {
                        var chatnew = ChatData(postid.toString(), msg, time)
                        myRef.push().setValue(chatnew)
//                        rvAdapter.notifyDataSetChanged()

                        var note = NoteData(roomname,datacontent.toString(),postid.toString(),from.toString())
                        NmyRef.push().setValue(note)
//                        Notedapter.notifyDataSetChanged()
                        //스크롤 포지션
                        rv.scrollToPosition(items.size - 1)
                        viewbinding.utextmsg.setText("")
                    }
                }
            }
        } else {
        //게시물을 보고 메시지를 보낼때
        val database = Firebase.database
        val myRef =
            database.getReference("message").child(postid.toString() + myid) //useroneusertwo
        val NmyRef = database.getReference("Note")

        val items: ArrayList<ChatData> = arrayListOf()
        val noteitems: ArrayList<NoteData> = arrayListOf()

        //리사이클러뷰 어댑터 연결
        val rv = findViewById<RecyclerView>(R.id.recycler_view)
        val rvAdapter = ChatAdapter(items, this, myid)
        val Notedapter = Notedapter(noteitems, this)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        viewbinding.umsgbtn.setOnClickListener {
            val time: String = WhatTime().toString()
            val msg: String = viewbinding.utextmsg.text.toString()
            if (msg.isNotEmpty()) {
                var chatnew = ChatData(myid, msg, time)
                myRef.push().setValue(chatnew)


                var note = NoteData(postid.toString() + myid,datacontent.toString(),myid, postid.toString())
                NmyRef.push().setValue(note)

                //스크롤 포지션
                rv.scrollToPosition(items.size - 1)
                viewbinding.utextmsg.setText("")
            }
        }

        myRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                var Chatd = dataSnapshot.getValue(ChatData::class.java)
                var name = Chatd?.mynickName
                var msg = Chatd?.msg
                var stime = Chatd?.time
                items.apply {
                    add(ChatData(name.toString(), msg.toString(), stime.toString()))
                }
                rvAdapter.notifyDataSetChanged()

            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })


        }


    }
}