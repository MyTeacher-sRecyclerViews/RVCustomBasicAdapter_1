package com.example.rviustombasicadapter_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rviustombasicadapter_1.adapter.CustomAdapter
import com.example.rviustombasicadapter_1.databinding.ActivityMainBinding
import com.example.rviustombasicadapter_1.model.Member

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        context = this
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }

    private fun initViews() {
        bin.recyclerview.layoutManager = GridLayoutManager(context, 2)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(context, members)
        bin.recyclerview.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()

        for (i in 0..50) {
            members.add(Member(randomName(), "$i"))
        }
        return members
    }

    private fun randomName(): String {
        val array = arrayListOf("Android", "Java", "Kotlin", "Dart", "Flutter")
        return array[(0 until array.size).random()]
    }
}