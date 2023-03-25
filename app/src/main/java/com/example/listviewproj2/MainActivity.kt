package com.example.listviewproj2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Saumya ma'am", "Hariom", "Prashant", "Nishant", "Mudit")

        val lastMsg = arrayOf("thanks ma'am for the course", "keep learning", "kaha ho", "enjoy your trip", "sup bro?")

        val lastMsgTime = arrayOf("5:00 PM", "7:30 PM", "2:00 AM", "2:15 PM", "7:30 PM")

        val phoneNumber = arrayOf("098776534", "1287656409", "8123345678", "2345667890", "2345678902")

        val imgId = intArrayOf(R.drawable.img_1, R.drawable.img, R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_5)

        userArrayList = ArrayList()

        for(eachIndex in name.indices){
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex],
                imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.ListView)
        listView.isClickable = true
        listView.adapter = MyAdapter(this, userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            // open a new activity

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this, UserActivity::class.java)

            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }

    }
}